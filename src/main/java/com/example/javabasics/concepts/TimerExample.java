package com.example.javabasics.concepts;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args){
        Timer timer = new Timer();


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Execute at time"+ LocalDateTime.now());
            }
        };

        timer.schedule(timerTask,0,3000);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.cancel();
    }
}
