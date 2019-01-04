package Stack.比较含退格的字符串;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        //遇到#就出栈
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack.isEmpty())
                    stack.pop();
                continue;
            } else {
                stack.push(S.charAt(i));
            }
        }
//        StringBuilder s = new StringBuilder();
//        while (!stack.isEmpty()) {
//            s.append(stack.pop());
//        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stack2.isEmpty())
                    stack2.pop();
                continue;
            } else {
                stack2.push(T.charAt(i));
            }
        }
//        StringBuilder t = new StringBuilder();
//        while (!stack.isEmpty()) {
//            t.append(stack.pop());
//        }

//        return t.toString().equals(s.toString());
        return stack.equals(stack2);
    }
}
