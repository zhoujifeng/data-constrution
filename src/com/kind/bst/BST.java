package com.kind.bst;

import com.kind.queue.LinkedListQueue;
import com.kind.queue.Queue;
import com.kind.stack.ArrayStack;
import com.kind.stack.LinkedListStack;
import com.kind.stack.Stack;

import java.util.Comparator;

/**
 * Created by Administrator on 2019/8/10.
 */
public class BST<E extends Comparable> {

    class Node<E> {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    private Node<E> root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //对于用户来说，就是插入一个e,而不需要理会我们是怎样实现的。
    public void add(E e) {
        root = add(root, e);
    }

    //宏观角度：向某个根节点，添加某个元素E
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

//    //宏观角度理解：向node节点为根的二分搜索树中插入元素E
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        }
//        Node nextNode = null;
//        if (e.compareTo(node.e) < 0) {
//            nextNode = node.left;
//            if (nextNode == null) {
//                node.left = new Node(e);
//                size ++;
//                return;
//            } else {
//                add(nextNode, e);
//            }
//        }
//
//        if (e.compareTo(node.e) > 0) {
//            nextNode = node.right;
//            if (nextNode == null) {
//                node.right = new Node(e);
//                size ++;
//                return;
//            } else {
//                add(nextNode, e);
//            }
//
//        }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        }
        //这样找，二分搜索树还有二分搜索的意义吗？
//        boolean restult = contains(node.left,e);
//        if(!restult){
//            restult = contains(node.right,e);
//        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrderNR() {

        Stack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }


    }

    //前序遍历以node为根的二分搜索树，递归算法
    public void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    public void levelOrder(){

        Queue<Node> q = new LinkedListQueue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            Node cur = q.dequeue();
            System.out.println(cur.e);

            if(cur.left != null ){
                q.enqueue(cur.left);
            }
            if(cur.right != null){
                q.enqueue(cur.right);
            }
        }
    }

    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return (E) mininum(root).e;
    }

    private Node mininum(Node node){
        if(node.left == null){
            return node;
        }
        return mininum(node.left);
    }


    public E maxmum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return (E) maxmum(root).e;
    }

    private Node maxmum(Node node){
        if(node.right == null){
            return node;
        }
        return mininum(node.right);
    }

    //从二分搜索树中删除最小值所在的节点
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小值得节点
    //返回删除节点后的新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node leftNode = node.right;
            node.right = null;
            size --;
            return leftNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    //从二分搜索树中删除最小值所在的节点
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点后的新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}



