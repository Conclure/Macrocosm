package me.conclure.macrocosm.model;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class UserRepository implements Iterable<User> {
    private final Map<UUID,User> userMap;

    public UserRepository(Map<UUID, User> userMap) {
        this.userMap = userMap;
    }

    public User getOrCreate(UUID uuid) {
        return this.userMap.computeIfAbsent(uuid, User::new);
    }

    public void remove(UUID uuid) {
        this.userMap.remove(uuid);
    }

    public boolean isPresent(UUID uuid) {
        return this.userMap.get(uuid) != null;
    }

    public User get(UUID uuid) {
        return this.userMap.get(uuid);
    }

    @Override
    public Iterator<User> iterator() {
        return this.userMap.values().iterator();
    }
}
