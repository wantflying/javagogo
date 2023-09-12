package leetcode;

import graph.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        if(s.length() <= 1 )return 0;
        char[] chars = s.toCharArray();
        boolean isBreak = false;
        int size =0;
        int maxSize = 0;
        Stack<Character> characterStack = new Stack<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ')'){
                if(characterStack.top() == '('){
                    characterStack.pop();
                    size++;
                    maxSize = Math.max(maxSize,size);
                }else {
                    size=0;
                }
            }else {
                characterStack.push(chars[i]);
            }
        }
        return maxSize*2;
    }
}
