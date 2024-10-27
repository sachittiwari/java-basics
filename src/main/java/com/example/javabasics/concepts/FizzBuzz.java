package com.example.javabasics.concepts;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args){

        IntStream.rangeClosed(1,100).mapToObj(i->{
            if(i%3==0 && i%5==0) return "FizzBuzz";
            else if(i%3==0) return "Fizz";
            else if(i%5==0) return "Buzz";
            else return String.valueOf(i);

        }).forEach(System.out::println);
    }
}
