package com.example.javabasics.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualsClass {
    public static void main(String[] args){
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3="Hello";

        //String equals vs ==
        System.out.println(s1.equals(s3));
        System.out.println(s1==s3);

        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);

        //Unmodifiable List
        List<String> arrayList = new ArrayList<>();
        arrayList.add("One");
        arrayList.add("One1");
        List<String> arrayList1 = Collections.unmodifiableList(arrayList);
        arrayList.add("One2");
        arrayList1.add("One34");

        System.out.println("Array List is"+arrayList1);
        System.out.println("Array List is"+arrayList);

        //Custom Array List Test
        CustomArrayList<String> a = new CustomArrayList<>();
        a.add("Sachit");
        System.out.println("Size is"+a.getSize()+" "+a);
        a.add("Sachit1");
        System.out.println("Size is"+a.getSize()+" "+a);
        a.remove("Sachit1");
        System.out.println("Size is"+a.getSize()+" "+a);




    }
}
