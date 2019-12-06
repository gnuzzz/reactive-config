package com.github.fit51.reactiveconfig.javadsl;

import cats.effect.IO;
import com.github.fit51.reactiveconfig.javadsl.reloadable.Restart;
import com.github.fit51.reactiveconfig.javadsl.reloadable.Simple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
public class TestReloadBehaviour {

    @Test
    @DisplayName("should successfully creates simple IO string behaviour")
    void testSimpleIOString() {
        Simple<IO<String>, String, String> behaviour = new Simple<>(IO::pure);
    }

    @Test
    @DisplayName("should successfully creates simple completion stage string behaviour")
    void testSimpleCompletionStageString() {
        Simple<CompletionStage<String>, String, String> behaviour = new Simple<>(CompletableFuture::completedFuture);
    }

    @Test
    @DisplayName("should successfully creates simple completion stage service behaviour")
    void testSimpleCompletionStageService() {
        Simple<CompletionStage<Service>, String, Service> behaviour = new Simple<>(s -> CompletableFuture.supplyAsync(() -> new Service(s)));
    }

    @Test
    @DisplayName("should successfully creates restart IO string behaviour")
    void testRestartIOString() {
        Restart<IO<String>, String, String> behaviour = new Restart<>((newS, currentS) -> IO.pure(newS));
    }

    @Test
    @DisplayName("should successfully creates restart completion stage string behaviour")
    void testRestartCompletionStageString() {
        Restart<CompletionStage<String>, String, String> behaviour = new Restart<>((newS, currentS) -> CompletableFuture.completedFuture(newS));
    }

    @Test
    @DisplayName("should successfully creates restart completion stage service behaviour")
    void testRestartCompletionStageService() {
        Restart<CompletionStage<Service>, String, Service> behaviour = new Restart<>((newS, currentS) -> CompletableFuture.supplyAsync(() -> {
            currentS.doStop();
            currentS.setValue(newS);
            currentS.doStart();
            return currentS;
        }));
    }

}
