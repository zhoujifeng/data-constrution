package com.kind.stack;

import com.kind.array.Array;

/**
 * Created by Administrator on 2019/7/14.
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayStack(){
        array = new Array<E>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpey();
    }

    //ArrayStack自己独有的方法
    public int getCapacity(){
        return array.getCapaciyt();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack : ");
        res.append("[");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(" , ");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
