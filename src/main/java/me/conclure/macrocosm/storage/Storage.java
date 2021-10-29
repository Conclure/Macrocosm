package me.conclure.macrocosm.storage;

import me.conclure.macrocosm.model.Hero;
import me.conclure.macrocosm.model.User;
import me.conclure.macrocosm.scheduler.Scheduler;

import java.util.concurrent.CompletableFuture;

public record Storage(Scheduler scheduler, StorageHandler storageHandler) {
    public void prepare() {
        this.storageHandler.prepare();
    }

    public CompletableFuture<Void> saveUser(User user) {
        return this.scheduler.completeAsyncExceptionally(() -> this.storageHandler.saveUser(user));
    }

    public CompletableFuture<Void> loadUser(User user) {
        return this.scheduler.completeAsyncExceptionally(() -> this.storageHandler.loadUser(user));
    }

    public CompletableFuture<Void> saveHero(Hero hero) {
        return this.scheduler.completeAsyncExceptionally(() -> this.storageHandler.saveHero(hero));
    }

    public CompletableFuture<Void> loadHero(Hero hero) {
        return this.scheduler.completeAsyncExceptionally(() -> this.storageHandler.loadHero(hero));
    }
}
