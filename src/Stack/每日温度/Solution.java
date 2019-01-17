package Stack.每日温度;

import java.util.Stack;

//[73,74,75,71,69,72,76,73]
class Solution {
    //递减栈 栈中存放的是每个元素的下标，当前元素大于栈顶元素时出栈，此时天数就为当前元素下标减出栈元素下标。小于等于栈顶元素时入栈。
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
