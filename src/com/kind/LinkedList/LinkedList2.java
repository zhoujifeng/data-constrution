package com.kind.LinkedList;

/**
 * Created by Administrator on 2019/7/20.
 */
public class LinkedList2<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node head;

    private int size;
    public LinkedList2() {
        head = new Node(null, null);
        size = 0;
    }

    //在链表中的index处添加一个新的元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node node = new Node(e);
        Node prev = head;
        if(size==0){
            head.e=e;
        }else{
        for (int i = 0; i < index - 1; i++) {
            //逐渐循环，找到插入位置的前一个位置
            prev = prev.next;
        }
        //将新建的node插入到正确的位置
        node.next = prev.next;
        prev.next = node;

        }
        //prev.next = new Node(e, prev.next);
        size++;

    }

    public void addLast(E e) {
        add(size, e);
    }


    public void deleteVar(E e){
        if(head.e == null){
            return;
        }

        if(head.e.equals(e)){
            head = head.next;
            head.next = null;
        }

        Node v=head;
        for(int i=0;i<size-1;i++){
            Node v2=v.next;
            if(v2.e.equals(e)){
                v.next=v2.next;
                v2.next = null;
                size --;
            }else
                v=v.next;
        }

    }

    public Node deleteVar2(E e){

        //如果我们的头节点等于需要删除的值，那么我们删除头节点。
        //如果删除之前的头节点之后，新的头节点还等于需要删除的值，那么我们继续删除头节点，所以这里是while循环
        while(head != null && head.e.equals(e)){
            Node del = head;
            head = head.next;
            del.next = null;
        }
        if(head == null){
            return null;
        }

        //当prev为最后一个，prev = prev.next,prev为null,判断prev.next时，会抛空指针异常
        //因为这样写，当前节点相等和不相等都会进行prev = prev.next操作。
        //但其实在相等时，不能下移，因为需要判断prev新的之后的节点是否相等
//        for(Node prev = head;prev.next !=null;prev=prev.next){
//            Node cur = prev.next;
//            if(cur.e.equals(e)){
//                prev.next = cur.next;
//                cur.next = null;
//                size --;
//            }
//        }

        Node prev = head;
        //只要定义了prev节点，那么我们一定是在校验prev的下一个节点
        while(prev.next != null){
            //说明我们将要判断的节点不会空
            if(prev.next.e.equals(e)){
                //如果数值相等，那么我们需要预先定义要删除的节点
                Node del = prev.next;
                //因为del节点是要被删除了，所以我们需要将prev下一个节点变量重新赋值，将del指向的下一个节点（对象）
                //赋值给prev.next
                //这里的思想跟删除head节点时，思想一样，不过我们对head操作时，是操作head当前节点，但操作prev时，是操作的下一个节点
                //所以这里都是对prev.next进行处理

                //如果想要处理head和处理其他的任何一个节点，都保持一种删除思想，那么我们需要我为head创建虚拟头节点（deleteVar3）
                prev.next = del.next;

                //当我们执行完prev.next = del.next,之后，虽然我们的prev的下一个节点直接指向了我们想要的那个节点，但我们从内存中还是能找到
                //delj节点，而且从del节点还是能找到链表之后的节点，这会造成虚拟机不进行垃圾回收。
                //所以我们执行del.next = null，让当前删除的节点完全脱离当前链条，成为内存中孤立的一个对象。
                del.next = null;

            }else{
                //如果数值不相等，那么说明我们判断的当前节点不需要被删除，那么我们将我们的prev节点后移。
                //prev重新赋值，指向新的对象节点。代表了我们将要判断的当前节点也会后移。
                prev = prev.next;
            }

        }



        return head;

    }

    public Node deleteVar3(E e){

        Node dummyHead = new Node(e);
        dummyHead.next = head;

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                Node del = prev.next;
                prev.next = del.next;
                del.next = null;
            }else {
                prev = prev.next;
            }
        }
        //这里一定要对head节点进行重新赋值。
        //因为开始时，Node prev = dummyHead,则意味着，开始时，prev在操作dummuyHead节点
        //prev.next = del.next 则意味着，dummyHead的next也发生了变化，而dummyHead.next又是head节点，所以head节点发生了变化
        //当执行过一次prev= prev.next之后，那么prev节点则不再代表是dummyHead节点
        head = dummyHead.next;
        return head;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        //Node cur = head;
//        for(int i=0;i<size;i++){
//            sb.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node cu = head; cu != null; cu = cu.next) {
            sb.append(cu + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList2<Integer> list = new LinkedList2();
        list.addLast(6);
        list.addLast(6);
        list.addLast(6);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        System.out.println(list);
        list.deleteVar3(6);
        System.out.println(list);

    }



}
