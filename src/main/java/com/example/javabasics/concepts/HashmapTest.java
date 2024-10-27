package com.example.javabasics.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class HashmapTest {
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        List<Runnable> listR = Arrays.asList(()->{map.put("1","2");},()->{map.put("2","2");},()->{map.put("3","2");},()->{map.put("4","2");},()->{map.put("5","2");},()->{map.put("6","2");});
        List<Future> fut = listR.stream().map(exec::submit).collect(Collectors.toList());
        fut.forEach(f-> {
            try {
                f.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        exec.shutdown();

        //map.put(null,"4");
        //map.put("4",null);
        map.forEach((x,y)->System.out.println("Key is"+x+"Value is"+y));

        ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<>();
        //map1.put(null,"1");
        //map1.put("1",null);
        map1.forEach((x,y)->System.out.println("Key is"+x+"Value is"+y));

        HashMap<String, Integer> countString = new HashMap<>();



        String a = "Sachit Sachit Tiwari Tiwari";
        String[] ab = a.split(" ");
        HashMap<String,Integer> abc = new HashMap<>();
        Arrays.stream(ab).forEach(x->abc.put(x,abc.getOrDefault(x,0)+1));
        abc.forEach((x,y)-> System.out.println("Key is"+x+" Value is"+y));


    }
}
