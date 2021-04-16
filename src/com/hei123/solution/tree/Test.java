package com.hei123.solution.tree;

//import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @author lishencai lisc@yealink.com
 * @date 2021/3/23
 * @since 1.0.0
 */
public class Test {

    private static final Unsafe U;
    private static final long OFFSET = 0L;

    static {

        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            U = (Unsafe) unsafe.get(null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    public static void main(String[] args) throws Exception {

        ExecutorService thread = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 15; i++) {
            final Monitor a = new Monitor();
            synchronized (a) {
                System.out.println("Main thread \t\t" + printHeader(a));
                System.out.println("Main thread 加锁，锁状态为");
                //System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
            System.out.println("Main thread 离开，锁状态为");
            //System.out.println(ClassLayout.parseInstance(a).toPrintable());

            thread.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    synchronized (a) {
                        System.out.println("Work thread 加锁，锁状态为");
                        //System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        System.out.println("Work thread \t\t" + printHeader(a));
                    }
                    System.out.println("Work thread 离开锁，锁状态为");
                    //System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    return null;
                }
            }).get();
        }

        thread.shutdown();
    }

    private static String printHeader(Object a) {
        int word = U.getInt(a, OFFSET);
        return Integer.toHexString(word);
    }

    private static class Monitor {
        // mutex object
    }
}
