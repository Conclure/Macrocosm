package me.conclure.macrocosm.storage;

import me.conclure.macrocosm.model.Hero;
import me.conclure.macrocosm.model.User;

public interface StorageHandler {
    void prepare();

    void saveUser(User user) throws Exception;

    void loadUser(User user) throws Exception;

    void saveHero(Hero hero) throws Exception;

    void loadHero(Hero hero) throws Exception;
}