package com.layle.algo.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4
 *
 * Created by layle on 2019-06-05.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println("Longest valid parentheses for \"(()\": " + longestValidParentheses("(()"));
        System.out.println("Longest valid parentheses for \")()())\": " + longestValidParentheses(")()())"));
    }

    /**
     * A stack can be used to track and reduce pairs. Since the problem asks for length, we can put the index into
     * the stack along with the character. For coding simplicity purpose, we can use 0 to respresnt ( and 1 to represent ).
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()[0]==0){
                    stack.pop();
                    result = Math.max(result, i-(stack.isEmpty()?-1:stack.peek()[1]));
                }else{
                    stack.push(new int[]{1, i});
                }
            }else{
                stack.push(new int[]{0, i});
            }
        }

        return result;
    }
}
