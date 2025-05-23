package org.example.singleton;

public class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;
    
    private StaticBlockSingleton() {
    }
    
    //static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
