package me.frogdog.frogpass.data;

import me.frogdog.frogpass.Main;

import java.io.File;

public abstract class Data {
    private File file;

    public Data(String filename) {
        this.file = new File(Main.getInstance().getDirectory(), filename);
        Main.getInstance().getDataManager().register(this);
    }

    public File getFile() {
        return this.file;
    }

    public abstract void load();

    public abstract void save();
}
