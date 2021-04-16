package com.hei123.solution.tree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lishencai lisc@yealink.com
 * @date 2021/3/31
 * @since 1.0.0
 */
public class ThreadInteruptTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 want get lock");
                reentrantLock.lock();
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t1.start();
        t2.start();

    }
}
