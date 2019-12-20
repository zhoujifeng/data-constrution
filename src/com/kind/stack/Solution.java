package com.kind.stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by Administrator on 2019/7/14.
 */
public class Solution {

    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c== '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(c == '(' && top != ')'){
                    return false;
                }
                if(c == '[' && top != ']'){
                    return false;
                }
                if(c == '{' && top != '}'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
