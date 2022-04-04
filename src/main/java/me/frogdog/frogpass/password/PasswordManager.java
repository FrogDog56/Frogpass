package me.frogdog.frogpass.password;

import com.google.gson.*;
import me.frogdog.frogpass.Main;
import me.frogdog.frogpass.data.Data;
import me.frogdog.frogpass.user.User;
import me.frogdog.frogpass.util.Registry;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

public final class PasswordManager extends Registry<Password> {
    private final String[] chars = {"a","b","c","d","e","f","g","h","i","j","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#","@",";","-","*","<",">"};

    public PasswordManager() {
        this.registry = new ArrayList<>();

        new Data("passwords.json") {

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

                try (FileReader reader = new FileReader(this.getFile())) {
                    root = new JsonParser().parse((Reader)reader);
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return;
                }

                if (!(root instanceof JsonArray)) {
                    return;
                }

                JsonArray passwords = (JsonArray)root;
                passwords.forEach(node -> {
                    if (!(node instanceof JsonObject)) {
                        return;
                    }
                    try {
                        JsonObject passwordNode = (JsonObject)node;
                        Main.getInstance().getPasswordManager().register(new Password(passwordNode.get("password-string").getAsString()));
                    }
                    catch (Throwable e) {
                        e.printStackTrace();
                    }
                });

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

                JsonArray passwords = new JsonArray();
                Main.getInstance().getPasswordManager().getRegistry().forEach(p ->{
                    try {
                        JsonObject password;
                        JsonObject props = password = new JsonObject();
                        props.addProperty("password-string", p.getPassword());
                        passwords.add((JsonElement) password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                try (FileWriter writer = new FileWriter(this.getFile())) {
                    writer.write(new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement)passwords));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public String generatePassword(int length) {
        String password;
        ArrayList<String> passwordArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(chars.length);
            passwordArray.add(chars[randIndex]);
        }

        password = passwordArray.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");

        return password;
    }
}
