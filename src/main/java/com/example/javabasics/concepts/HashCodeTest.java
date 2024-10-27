package com.example.javabasics.concepts;

import java.util.*;

public class HashCodeTest {


        public static void main(String[] args){

            List<String> list = new ArrayList<>();

            String a= "Sachit";
            //System.out.println("Hash Code of String is"+a.hashCode());
            String b = "Sachit";
            a="Sachit1";
            int a1 = (int)'c';


            /*System.out.println("Hash Code of String is"+a.hashCode());
            System.out.println("Hash Code of String is"+b.hashCode());*/
            String post = "Sachin";
            String post1 = new String("Sachin");
            String post2 = new String("Sachin");

            System.out.println("Hash Code of post is"+post.hashCode());
            System.out.println("Hash Code of post1 is"+post1.hashCode());
            System.out.println("Hash Code of post2 is"+post2.hashCode());
            /*list.add("Sachit Tiwari");
            String a = "Sachit Tiwari Sachit Tiwari Sachit Tiwari";
            HashMap<String, Integer> countString = new HashMap<>();
            String[] ab = a.split(" ");
            for(int i=0;i<ab.length;i++){
                if(countString.containsKey(ab[i]))
                    countString.put(ab[i],countString.get(ab[i])+1);
                else
                    countString.put(ab[i],1);
            }
           // Iterator<String> iterKeys = countString.keySet().iterator();
            for(Map.Entry iter: countString.entrySet()){
                System.out.println("Using Map.Entry: Key is"+iter.getKey()+"Value is"+iter.getValue());
            }






            System.out.println("Normal is"+countString.toString());*/



        }


}
