package com.samar.bootcamp.ThreadPool;

public class ThreadPoolTester {

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5);

        pool.submit(new Task(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " alpha");
            }
        }));

        pool.submit(new Task(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " beta");
            }
        }));

        pool.submit(new Task(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " charlie");
            }
        }));

        pool.submit(new Task(12, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " delta");
            }
        }));

        pool.submit(new Task(15, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ena");
            }
        }));

        pool.submit(new Task(9, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " fargo");
            }
        }));

        pool.submit(new Task(1, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " germany");
            }
        }));

        pool.submit(new Task(7, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " hannah");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        }));

        /*at the end of main() usually JVM terminates but will not happens so this
        * time, that's because, we have 5 threads running in background. Although,
        * main thread is completed and terminated but JVM still has 5 thread running.
        * */
    }
}
