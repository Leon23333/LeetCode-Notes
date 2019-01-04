package Stack.棒球比赛;

import java.util.Stack;

class Solution {
    /*
    1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
    2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
    3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
    4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
    */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<ops.length;i++){
            switch (ops[i]){
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek()*2);
                    break;
                case "+":
                    int pre1 = stack.pop();
                    int pre2 = stack.peek();
                    stack.push(pre1);
                    stack.push(pre1+pre2);
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
                    break;
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
