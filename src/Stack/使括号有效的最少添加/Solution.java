package Stack.使括号有效的最少添加;

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int n = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    n--;
                } else {
                    stack.push(S.charAt(i));
                    n++;
                }
            } else {
                stack.push(S.charAt(i));
                n++;
            }
        }
        return n;
    }
}
