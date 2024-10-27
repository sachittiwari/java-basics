package com.example.javabasics.concepts;

import java.util.concurrent.*;

public class ProducerConsumer {

    public static void main(String[] args){

        SharedClass sh = new SharedClass();
        Thread producer = new Thread(()->{
            try {
                while(true) {
                    sh.produce();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        Thread consumer = new Thread(()->{
            try {
                while(true) {
                    sh.consume();
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });
        producer.start();
        consumer.start();
    }
}

class SharedClass{
    private boolean flag = false;

    public synchronized void produce() throws InterruptedException {
        while(flag)
            wait();
        flag=true;
        System.out.println("Produce data");
        notify();

    }

    public synchronized void consume() throws InterruptedException {
        while(!flag)
            wait();
        flag=false;
        System.out.println("consume data");
        notify();
    }
}
