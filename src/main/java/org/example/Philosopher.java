package org.example;

public class Philosopher extends Thread {
    private Object locker ;

    public Philosopher(String name, Object locker) {
        super(name);
        this.locker = locker;
    }
    public void doSomething(String action) throws InterruptedException {
        String currentPhil = Thread.currentThread().getName();
        System.out.println("Философ №"+currentPhil +" "+ action);
        if (action.equals("ест")){
            Thread.currentThread().sleep(500);
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                synchronized (locker){
                    doSomething("ест");
                }
                doSomething("думает");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
