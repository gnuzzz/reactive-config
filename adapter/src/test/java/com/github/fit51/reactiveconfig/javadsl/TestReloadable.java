package com.github.fit51.reactiveconfig.javadsl;

import com.github.fit51.reactiveconfig.javadsl.reloadable.Map;
import com.github.fit51.reactiveconfig.javadsl.reloadable.Reloadable;
import com.github.fit51.reactiveconfig.javadsl.reloadable.ReloadableImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import scala.Function1;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
public class TestReloadable {

    @Test
    @DisplayName("should")
    void test() {
        Reloadable<CompletionStage<String>, String> r = new ReloadableImpl<CompletionStage<String>, String>(reloadable(), TestReloadable::mapCompletionStage);
    }

    private com.github.fit51.reactiveconfig.reloadable.ReloadableImpl<CompletionStage<String>, String, String> reloadable() {
        return new com.github.fit51.reactiveconfig.reloadable.ReloadableImpl<>(
                "initial",
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public static <V, NEW_V> CompletionStage<NEW_V> mapCompletionStage(CompletionStage<V> cs, Function<V, NEW_V> mapFunction) {
        return cs.thenApply(mapFunction);
    }

    static class CompletionStageMapper implements Map<CompletionStageMapper> {
        @Override
        public <V, NEW_V> CompletionStageMapper map(CompletionStageMapper completionStageMapper, Function1<V, NEW_V> mapFunction) {
            return null;
        }
    }

}
