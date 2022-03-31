package me.frogdog.frogpass.user;

import me.frogdog.frogpass.util.Registry;

import java.util.ArrayList;

public class UserManager extends Registry<User> {

    public UserManager() {
        this.registry = new ArrayList<>();
    }
}
