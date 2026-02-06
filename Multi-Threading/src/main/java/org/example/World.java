package org.example;

public class World implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from world");
        System.out.println(Thread.currentThread().getName());
    }
}
