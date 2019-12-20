package com.kind.array;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array();
        for(int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr.toString());
        arr.add(2,100);
        System.out.println(arr.toString());
        arr.addFirst(-1);
        System.out.println(arr.toString());
        arr.remove(2);
        System.out.println(arr.toString());
        arr.removeElement(4);

        arr.remove(4);
        System.out.println(arr.toString());    }
}
