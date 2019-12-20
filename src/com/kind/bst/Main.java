package com.kind.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2019/8/10.
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//
//        int[] nums = {5,3,6,8,4,2};
//        for(int num : nums){
//            bst.add(num);
//        }
//
////        bst.preOrder();
////        System.out.println();
////        bst.preOrderNR();
//        bst.levelOrder();
//        //System.out.print(bst.toString());

        Random random = new Random();
        int n  = 1000;
        for(int i=0;i<n;i++){
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMax());
        }
        System.out.println(nums);

        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)<nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("removeMax test completed");


    }
}
