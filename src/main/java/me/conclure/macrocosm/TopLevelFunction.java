package me.conclure.macrocosm;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TopLevelFunction {
    default <T> T await(CompletableFuture<T> future) {
        return future.join();
    }
}
