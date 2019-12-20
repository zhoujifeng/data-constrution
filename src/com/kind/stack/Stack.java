package com.kind.stack;

/**
 * Created by Administrator on 2019/7/14.
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();


}
