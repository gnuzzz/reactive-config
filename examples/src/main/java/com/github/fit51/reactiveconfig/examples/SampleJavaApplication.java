package com.github.fit51.reactiveconfig.examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fit51.reactiveconfig.config.ReactiveConfig;
import com.github.fit51.reactiveconfig.parser.JacksonConfigDecoder;
import com.github.fit51.reactiveconfig.reloadable.ReloadBehaviour;
import com.github.fit51.reactiveconfig.reloadable.Reloadable;
import com.github.fit51.reactiveconfig.reloadable.Simple;
import monix.eval.Task;
import monix.execution.Cancelable;
import scala.Tuple2;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
public class SampleJavaApplication {

    private static Task<Cancelable> useConfig(ReactiveConfig<Task, JsonNode> config) {
        Reloadable<Task, String, String> some = config.reloadable("complex-app.something", JacksonConfigDecoder.decoder(String.class));
        Reloadable<Task, SimpleLib, SimpleLib> libConfig = config.reloadable("complex-app.simple-lib-context.simple-lib", JacksonConfigDecoder.decoder(SimpleLib.class));
        ReloadBehaviour<Task, Tuple2<SimpleLib, String>, SimpleLib> simpleBehaviour = new Simple<>();
        Reloadable<Task, Tuple2<SimpleLib, String>, SimpleLib> combined = libConfig.combine(some, (l, s) -> l.copy(s, l.whatever()), simpleBehaviour);

        return Task.eval(() -> {
            System.out.println("Entered");
            return JavaHelper.scheduler().scheduleWithFixedDelay(0, 1, TimeUnit.SECONDS, () -> {
                System.out.println("some: " + some.get());
                System.out.println("lib: " + libConfig.get());
                System.out.println("all together: " + combined.get());
            });
        });
    }

    public static void main(String[] args) throws Exception {
        Task app = Task.eval(() -> JavaHelper.typesafeConfigStorage(Paths.get("examples/config/application.conf")))
                .flatMap(storage -> JavaHelper.reactiveConfig(storage))
                .flatMap(config -> Task.eval(() -> { System.out.println("Now change examples/config/application.conf file and see what happens!"); return null; })
                .flatMap(notUsed -> useConfig(config))
                .flatMap(cancellable -> Task.sleep(Duration.apply(1, TimeUnit.MINUTES))
                .flatMap(notUsed -> Task.eval(() -> { cancellable.cancel(); return null; }))));

        Await.result(
                app.doOnFinish(result -> {
                    if (result instanceof scala.Some) {
                        return Task.eval(() -> { System.out.println("Error: " + ((scala.Some)result).get()); return null; });
                    } else if (result instanceof scala.None$) {
                        return Task.eval(() -> { System.out.println("Finished"); return null; });
                    } else {
                        return Task.eval(() -> { System.out.println("Unexpected result: " + result); return null; });
                    }
                }).runToFuture(JavaHelper.scheduler()),
                Duration.Inf()
        );
    }

}
