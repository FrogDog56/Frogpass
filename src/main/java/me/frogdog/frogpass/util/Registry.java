package me.frogdog.frogpass.util;

import java.util.List;

public class Registry<T> {

    protected List<T> registry;

    public void register(T element) {
        this.registry.add(element);
    }

    public void unregister(T element) {
        this.registry.forEach(e -> {
            if (e.equals(element)) {
                this.registry.remove(e);
            }
        });
    }

    public void clear() {
        this.registry.clear();
    }

    public List<T> getRegistry() {
        return this.registry;
    }
}
