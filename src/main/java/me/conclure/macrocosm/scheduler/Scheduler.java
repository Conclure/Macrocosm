package me.conclure.macrocosm.scheduler;

import me.conclure.macrocosm.util.function.ThrowingRunnable;
import me.conclure.macrocosm.util.function.ThrowingSupplier;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public interface Scheduler {

    void runAsync(Runnable runnable);

    default void runAsyncExceptionally(ThrowingRunnable<Exception> runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            throw e instanceof RuntimeException ex ? ex : new CompletionException(e);
        }
    }

    CompletableFuture<Void> completeAsync(Runnable runnable);

    default CompletableFuture<Void> completeAsyncExceptionally(ThrowingRunnable<Exception> runnable) {
        return this.completeAsync(() -> {
           try {
               runnable.run();
           } catch (Exception e) {
               throw e instanceof RuntimeException ex ? ex : new CompletionException(e);
           }
        });
    }

    <T> CompletableFuture<T> completeAsync(Supplier<T> supplier);

    default <T> CompletableFuture<T> completeAsyncExceptionally(ThrowingSupplier<T,Exception> supplier) {
        return this.completeAsync(() -> {
            try {
                return supplier.get();
            } catch (Exception e) {
                throw e instanceof RuntimeException ex ? ex : new CompletionException(e);
            }
        });
    }

    ScheduledFuture<?> laterAsync(Runnable runnable, TimeUnit unit, long delay);

    ScheduledFuture<?> repeatAsync(Runnable runnable, TimeUnit unit, long interval);
}