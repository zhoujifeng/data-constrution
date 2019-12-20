package com.kind.stack;

/**
 * Created by Administrator on 2019/7/17.
 */
public class EffiMain {

    public static double testStack(Stack<Integer> stack, int opCount) {

        long start = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < stack.getSize(); i++) {
            stack.pop();
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }


    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack Time : " + time1);
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack Time : " + time2);
    }
}
