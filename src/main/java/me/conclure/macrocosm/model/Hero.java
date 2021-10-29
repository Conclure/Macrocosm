package me.conclure.macrocosm.model;

import java.util.UUID;

public class Hero {
    private final User user;
    private final UUID uniqueId;

    public Hero(User user, UUID uniqueId) {
        this.user = user;
        this.uniqueId = uniqueId;
    }

    public User getUser() {
        return user;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}