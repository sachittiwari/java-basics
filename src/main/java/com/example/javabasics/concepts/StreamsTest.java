package com.example.javabasics.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args){
        Stream<String> str = Stream.empty();
        Stream<String> arr = Stream.of("Sachit","Tiwari","Puttu");

        String[] a = new String[] {"Sachit","Tiwari"};
        Stream<String> b = Arrays.stream(a,1,2);
        Stream<Integer> c = Stream.<Integer>builder().add(1).build();

        Stream<String> generate = Stream.generate(()->"Test").limit(10);

        Stream<String> iterate = Stream.iterate("Sachit",n->n+"1").limit(1);

        List<String> list = Arrays.asList("Sa","chit","Tiwari","Puttu");
        List<String> newList = list.stream().filter(s->s.startsWith("Sa")).collect(Collectors.toList());
        long newa = list.stream().filter(s->s.startsWith("Sa")).count();
        Optional<String> latestList = list.stream().collect(Collectors.maxBy(String::compareTo));
        //list.stream().peek(x->System.out.println("This is "+x)).forEach(num->System.out.println(num));

        //list.parallelStream().peek(x->System.out.println("This is "+x+" "+Thread.currentThread().getName())).forEach(num->System.out.println(num));
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);


          List<Runnable> list1 = new ArrayList<>();
            ExecutorService exec = Executors.newFixedThreadPool(10);
            List<Future> fut = list1.stream().map(exec::submit).collect(Collectors.toList());
            fut.forEach(f-> {
                try {
                    f.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });

      try {
            forkJoinPool.submit(()->{
                list.parallelStream().peek(x->System.out.println("This is "+x+" "+Thread.currentThread().getName())).forEach(num-> {

                });
            }
            ).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //forkJoinPool.shutdown();


    }

    public int add(int a){
        return 1;
    }

    public boolean add(int a,int b){
        return true;
    }
}
