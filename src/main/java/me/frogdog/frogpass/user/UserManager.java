package me.frogdog.frogpass.user;

import com.google.gson.stream.JsonWriter;
import me.frogdog.frogpass.Main;
import me.frogdog.frogpass.data.Data;
import me.frogdog.frogpass.util.Registry;

import java.io.*;
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
                try {
                    if (!this.getFile().exists()) {
                        this.getFile().createNewFile();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    JsonWriter writer = new JsonWriter(new FileWriter(this.getFile()));
                    writer.beginObject();
                    writer.name("data");
                    writer.beginArray();
                    for (User u : Main.getInstance().getUserManager().getRegistry()) {
                        writer.beginObject();
                        writer.name("username").value(u.getUsername());
                        writer.name("password").value(u.getPassword());
                        writer.endObject();
                    }
                    writer.endArray();
                    writer.endObject();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }
}
