package org.example;

import org.example.singleton.*;

import java.io.*;
import java.lang.reflect.Constructor;
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        eagerInitializedSingleton();

        staticBlockSingleton();

        threadSafeSingleton();

        enumSingleton();

        holderSingletonTest();

        threadSafeSingletonDoubleCheckLocking();

        threadLocalSingletonTest();

        billPughSingleton();

        reflectionSingleton();

        serializedSingleton();


    }

    static void eagerInitializedSingleton() {
        EagerInitializedSingleton eis1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eis2 = EagerInitializedSingleton.getInstance();

        System.out.println("EagerInitializedSingleton 1: " + eis1.hashCode());
        System.out.println("EagerInitializedSingleton 2: " + eis2.hashCode());
    }

    static void staticBlockSingleton() {
        StaticBlockSingleton sbs1 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton sbs2 = StaticBlockSingleton.getInstance();

        System.out.println("StaticBlockSingleton 1: " + sbs1.hashCode());
        System.out.println("StaticBlockSingleton 2: " + sbs2.hashCode());
    }

    static void threadSafeSingleton() {
        ThreadSafeSingleton tss1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton tss2 = ThreadSafeSingleton.getInstance();

        System.out.println("ThreadSafeSingleton 1: " + tss1.hashCode());
        System.out.println("ThreadSafeSingleton 2: " + tss2.hashCode());
    }

    static void threadSafeSingletonDoubleCheckLocking() {
        ThreadSafeSingleton dcl1 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        ThreadSafeSingleton dcl2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();

        System.out.println("ThreadSafeSingleton Double Check Locking 1: " + dcl1.hashCode());
        System.out.println("ThreadSafeSingleton Double Check Locking 2: " + dcl2.hashCode());
    }

    static void billPughSingleton() {
        BillPughSingleton bps1 = BillPughSingleton.getInstance();
        BillPughSingleton bps2 = BillPughSingleton.getInstance();

        System.out.println("BillPughSingleton 1: " + bps1.hashCode());
        System.out.println("BillPughSingleton 2: " + bps2.hashCode());
    }

    static void holderSingletonTest() {
        HolderSingleton hs1 = HolderSingleton.getInstance();
        HolderSingleton hs2 = HolderSingleton.getInstance();

        System.out.println("HolderSingleton 1: " + hs1.hashCode());
        System.out.println("HolderSingleton 2: " + hs2.hashCode());

    }

    static void reflectionSingleton() {
        EagerInitializedSingleton instanceOne =
                EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors =
                    EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton)
                        constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Instance 1: " + instanceOne.hashCode());
        System.out.println("Instance 2: " + instanceTwo.hashCode());
    }

    static void enumSingleton() {
        EnumSingleton es1 = EnumSingleton.INSTANCE;
        EnumSingleton es2 = EnumSingleton.INSTANCE;

        System.out.println("EnumSingleton 1: " + es1.hashCode());
        System.out.println("EnumSingleton 2: " + es2.hashCode());
    }

    static void serializedSingleton() throws IOException, ClassNotFoundException {
        SerializedSingleton ss1 = SerializedSingleton.getInstance();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(ss1);
        out.close();


        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton ss2 = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("SerializedSingleton 1: " + ss1.hashCode());
        System.out.println("SerializedSingleton 2: " + ss2.hashCode());
    }

    static void threadLocalSingletonTest() {
        Runnable task = () -> {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> Instance HashCode: " + instance.hashCode());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}