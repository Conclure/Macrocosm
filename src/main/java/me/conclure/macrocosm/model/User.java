package me.conclure.macrocosm.model;

import java.util.UUID;

public class User {
    private Hero currentHero;
    private final UUID uuid;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public void setCurrentHero(Hero currentHero) {
        this.currentHero = currentHero;
    }
}