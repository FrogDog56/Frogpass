package me.frogdog.frogpass.data;

import me.frogdog.frogpass.util.Registry;

import java.util.ArrayList;

public final class DataManager extends Registry<Data> {

    public DataManager() {
        this.registry = new ArrayList<>();
    }
}
