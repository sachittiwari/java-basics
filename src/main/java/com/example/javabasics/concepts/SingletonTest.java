package com.example.javabasics.concepts;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingletonTest {

    public static void main(String[] args){
        //Singleton Class
        SingletonExample sin = SingletonExample.getObject();
        SingletonExample sin1 = SingletonExample.getObject();
       /* System.out.println("Info is: "+sin.getInfo());
        sin1.setInfo("Capgemini");
        System.out.println("Info is: "+sin.getInfo());
        System.out.println("Info is: "+sin1.getInfo());*/
        System.out.println("Hash code of first object using Singleton Class sin is: "+sin.hashCode());
        System.out.println("Hash code of first object using Singleton Class sin is: "+sin1.hashCode());

        //Singleton Enum
        EnumSingleton e = EnumSingleton.INSTANCE1.getInstance();
        EnumSingleton e1 = EnumSingleton.INSTANCE1.getInstance();

        System.out.println("Hash code of first object using Enum e is: "+e.hashCode());
        System.out.println("Hash code of first object using Enum e is: "+e1.hashCode());

        //Reflection
        Constructor[] con = new Constructor[10];
        con = SingletonExample.class.getDeclaredConstructors();
        Arrays.stream(con).filter(x->!x.isAccessible()).forEach(x->x.setAccessible(true));




    }
}
