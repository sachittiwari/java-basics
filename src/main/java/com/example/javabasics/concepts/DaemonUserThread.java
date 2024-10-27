package com.example.javabasics.concepts;

public class DaemonUserThread {
    public static void main(String[] args){

        Thread t =  new Thread(()-> {
            while (true) {
                System.out.println("Daemon thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.setDaemon(true);


        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(10000);
                System.out.println("user thread finished execution");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        Runnable r = new Thread(()->{
            System.out.println("a");
        });
        r.run();

    }
}
class t1 implements Runnable{

    @Override
    public void run() {
        System.out.println("one is here");
        Thread t3 = new Thread(()->{});
    }
}
