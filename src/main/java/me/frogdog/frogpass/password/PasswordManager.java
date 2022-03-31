package me.frogdog.frogpass.password;

import me.frogdog.frogpass.util.Registry;

import java.util.ArrayList;

public final class PasswordManager extends Registry<Password> {

    public PasswordManager() {
        this.registry = new ArrayList<>();
    }
}
