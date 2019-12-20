package com.kind.stack;

import com.kind.LinkedList.LinkedList;

/**
 * Created by Administrator on 2019/7/17.
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> data;

    public LinkedListStack(){
        data = new LinkedList<E>();
    }


    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("stack : top ");
        res.append(data);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack.toString());
        }
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());


    }
}
