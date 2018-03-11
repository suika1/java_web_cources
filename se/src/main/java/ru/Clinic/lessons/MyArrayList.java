package ru.Clinic.lessons;

import java.util.*;

/**
 * Created by user on 15.01.2018.
 */
public class MyArrayList<E> {

    private int startSize = 10;

    private int realSize = 0;

    private Object[] array = new Object[startSize];

    public int arraySize() {
        return array.length;
    }

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int size){
        if(size<0)
            this.startSize = 10;
        else this.startSize = size;
    }

    public void add(E e){
        if (this.realSize<this.array.length){
            System.out.println("1!");
            this.array[realSize]=e;
            this.realSize++;
        }else{
            System.out.println("2!");
            Object[] newArray = new Object[(this.array.length * 3) / 2];
            System.arraycopy(this.array, 0, newArray,0, this.array.length);
            this.array = newArray;
            this.array[realSize]=e;
            realSize++;
        }
    }


    public boolean remove(Object obj){
        int remObj = 0; // counter for removing objects
        for (Object o:array){
            if (o.equals(obj)){
                remObj++;
            }
        }
        System.out.println("remObj = "+remObj);
        if (remObj>0){
            Object[] newArray = new Object[this.arraySize() - 1];
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(obj)) {
                    System.arraycopy(this.array, 0, newArray, 0, i);
                    System.arraycopy(this.array, i + 1, newArray, i, newArray.length - (i));
                    this.array = newArray;
                    realSize--;
                    return true;
                }
            }
        }
        return false;
    }



}
