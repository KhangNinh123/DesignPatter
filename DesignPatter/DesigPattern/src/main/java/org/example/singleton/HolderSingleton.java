package org.example.singleton;

public class HolderSingleton {
    private static HolderSingleton instance;

    private HolderSingleton() {}

    public static HolderSingleton getInstance() {
        if (instance == null) {
            instance = new HolderSingleton();
        }
        return instance;
    }
}

