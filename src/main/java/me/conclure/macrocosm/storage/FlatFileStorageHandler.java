package me.conclure.macrocosm.storage;

import me.conclure.macrocosm.model.Hero;
import me.conclure.macrocosm.model.User;

import java.nio.file.Path;

public class FlatFileStorageHandler implements StorageHandler {
    private final Path topDirectory;
    private final Path userDirectory;

    public FlatFileStorageHandler(Path topDirectory) {
        this.topDirectory = topDirectory;
        this.userDirectory = topDirectory.resolve("user");
    }

    @Override
    public void prepare() {

    }

    @Override
    public void saveUser(User user) throws Exception {

    }

    @Override
    public void loadUser(User user) throws Exception {

    }

    @Override
    public void saveHero(Hero hero) throws Exception {

    }

    @Override
    public void loadHero(Hero hero) throws Exception {

    }
}
