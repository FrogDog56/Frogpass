package me.frogdog.frogpass.user;

import me.frogdog.frogpass.Main;
import me.frogdog.frogpass.util.Registry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserManager extends Registry<User> {
    private final File file;

    public UserManager() {
        this.registry = new ArrayList<>();
        this.file = new File(Main.getInstance().getDirectory(), "user.json");
    }

    public void load() {
        try {
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
