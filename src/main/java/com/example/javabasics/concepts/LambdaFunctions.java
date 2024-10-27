package com.example.javabasics.concepts;

import java.util.*;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args){
        //Lambda function using single operator
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(6);
        arr.forEach(n -> {
            if(n%2==0)
                System.out.println(n);});

        //lambda function using multiple operators
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Sachit",1);
        map.put("Tiwari",2);
        map.forEach((String x,Integer y)->{System.out.println("Key is"+x+"Value is"+y);});

        //lambda function using functional interface
        FuctionalInter add = (a, b) -> a+b;
        FuctionalInter sub = (a, b) -> a-b;

        //Java consumer functional interface
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("5");
        arr1.add("6");
        Consumer<String> cons = String::length;
        arr1.forEach(cons);

        //map.forEach(x->System.out.println(x.length()));
        String[] a = {"a","b","c"};
        int[] b = new int[]{1,2,3};

        HashMap<String,Integer> countString = new HashMap<>();
        countString.put("Sachit",1);
        countString.put("Tiwari",2);
        //countString.computeIfPresent("Sachit",k->4);
        countString.forEach((x,y)-> System.out.println("Key is"+x+"Value is"+y));
       // Map.computeIfAbsent("key", k -> );

        /*//FuctionalInter run = ()->{return "a";};
        Arrays.sort(a,String::length);
        Consumer<HashSet> countString1 = HashSet::new;*/





    }
}


interface FuctionalInter{
    int operation(int a, int b);
}
