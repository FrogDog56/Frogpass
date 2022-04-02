package me.frogdog.frogpass.user;

import com.google.gson.*;
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
                JsonElement root;

                try {
                    if (!this.getFile().exists()) {
                        this.getFile().createNewFile();
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (Main.getInstance().getUserManager().getRegistry().isEmpty()) {
                    return;
                }

                try (FileReader reader = new FileReader(this.getFile())) {
                    root = new JsonParser().parse((Reader)reader);
                    JsonObject node = (JsonObject)root;
                    Main.getInstance().getUserManager().register(new User(node.get("username").getAsString(), node.get("password").getAsString()));
                }
                catch (IOException e) {
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

                if (Main.getInstance().getUserManager().getRegistry().isEmpty()) {
                    return;
                }

                try (FileWriter writer = new FileWriter(this.getFile())) {
                    User user = Main.getInstance().getUserManager().getRegistry().get(0);
                    writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(user));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
