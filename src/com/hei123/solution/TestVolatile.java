package com.hei123.solution;

public class TestVolatile {

    public boolean running=true;

    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testVolatile.dorun();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                testVolatile.stop();
            }
        }).start();

    }

    public void dorun() throws InterruptedException {
        int i=0;
        while (running) {
            i++;
//            Thread.sleep(10);
//            System.out.println(running);
        }
        System.out.println(i);
        System.out.println("i have stoped");
    }

    public void stop() {
        this.running = false;
        System.out.println();
    }
}
