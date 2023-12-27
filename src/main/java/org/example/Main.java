package org.example;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 1; i <=5; i++) {
            Philosopher philosopher = new Philosopher(Integer.toString(i), lock);
            philosopher.start();
        }

    }



}
