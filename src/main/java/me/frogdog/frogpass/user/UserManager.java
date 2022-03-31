package me.frogdog.frogpass.user;

import me.frogdog.frogpass.Main;
import me.frogdog.frogpass.data.Data;
import me.frogdog.frogpass.util.Registry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class UserManager extends Registry<User> {

    public UserManager() {
        this.registry = new ArrayList<>();

        new Data("user.json") {

            @Override
            public void load() {
                try {
                    if (!this.getFile().exists()) {
                        this.getFile().createNewFile();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void save() {

            }
        };

    }
}
