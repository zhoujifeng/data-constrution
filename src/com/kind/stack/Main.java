package com.kind.stack;

/**
 * Created by Administrator on 2019/7/14.
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i=0;i<5;i++){
            stack.push(i);
        }
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());


    }
}
