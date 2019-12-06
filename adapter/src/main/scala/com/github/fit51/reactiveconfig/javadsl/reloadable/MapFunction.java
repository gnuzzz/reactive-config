package com.github.fit51.reactiveconfig.javadsl.reloadable;

import java.util.function.Function;

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
@FunctionalInterface
public interface MapFunction<F, V, R> {
    <A, B> F<B> apply(F<A> task, Function<V, R> f);
}
