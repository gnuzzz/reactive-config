package com.github.fit51.reactiveconfig.examples;

//import com.github.fit51.reactiveconfig.javadsl.reloadable.Reloadable;
//import com.github.fit51.reactiveconfig.reloadable.Simple;

import cats.effect.IO;
import com.github.fit51.reactiveconfig.javadsl.reloadable.Simple;
import com.github.fit51.reactiveconfig.javadsl.reloadable.Stop;

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
public class SampleJavaApplication {

    public static void main(String[] args) throws Exception {
//        Reloadable<String> some = null;
//        Reloadable<SimpleLib> libConfig = null;
//        Reloadable<SimpleLib> combined1 = libConfig.combine(some, (l, s) -> l.copy(s, l.whatever()), new Simple<>());
//        Reloadable<SimpleLib> combined2 = libConfig.combine(some, (l, s) -> l.copy(s, l.whatever()));

//        com.github.fit51.reactiveconfig.javadsl.reloadable.Simple<?, SimpleLib, String> simple = new Simple<Object, SimpleLib, String>((l, s) -> l.copy(s, l.whatever()));
        Stop<IO<String>, SimpleLib, String> simple = new Stop<IO<String>, SimpleLib, String>(null, null, null);
    }

}
