package com.example.javabasics.concepts;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomArrayList<T> {
    private Object[] elements;
    private int size;

    private static final int DEFAULT_SIZE = 1;

    CustomArrayList(){
        elements = new Object[DEFAULT_SIZE];
    }

    public void add(Object element){
        if(size<DEFAULT_SIZE || size < elements.length ){
            elements[size++] = element;
        }
        else{
            System.out.println("Inside extend"+elements.length);
            extendArray();
            System.out.println("After extend"+elements.length);
            elements[size++] = element;
        }

    }

    public void remove(Object element){
        OptionalInt isPresent = IntStream.range(0,elements.length).filter(x->elements[x]==element).findAny();
            if(isPresent.getAsInt()>=0) {
                System.out.println("Inside remove if");
                elements[isPresent.getAsInt()] = null;
                downsize();
            }

    }

    public int getSize(){
        return size;
    }

    private void downsize(){
        List<Object> resizedArray = new ArrayList<>();
        IntStream.range(0,elements.length).filter(x->elements[x]!=null).forEach(x->{
            resizedArray.add(elements[x]);
        });
        elements = resizedArray.toArray();
        size--;
    }

    private void extendArray(){
        Object[] extendedArray = new Object[elements.length+10];
        List<Object> resizedArray = new ArrayList<>();
        IntStream.range(0,elements.length).forEach(x->{
            extendedArray[x] = elements[x];
        });
        this.elements = extendedArray;
    }

    @Override
    public String toString() {
        IntStream.range(0,elements.length).filter(x->elements[x]!=null).forEach(x-> System.out.println(elements[x].toString()));
        return "Done";
    }
}
