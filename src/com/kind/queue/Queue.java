package com.kind.queue;

/**
 * Created by Administrator on 2019/7/14.
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();


}
