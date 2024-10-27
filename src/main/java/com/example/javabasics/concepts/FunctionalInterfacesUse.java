package com.example.javabasics.concepts;

import java.util.function.Predicate;

public class FunctionalInterfacesUse {
    public static void main(String[] args) {
        Predicate<String> pred= s->s.contains("Sachit")?false:true;
        System.out.println(pred.test("Sachint Tiwari"));


    }

}

/*@FunctionalInterface
interface Predicate<T>{
    boolean checkValid(T t);
}*/
