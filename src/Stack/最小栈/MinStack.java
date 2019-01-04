package Stack.最小栈;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minValue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minValue = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            minValue.push(x);
        }else {
            stack.push(x);
            if (x <= minValue.peek()){
                minValue.push(x);
            }
        }
    }

    public void pop() {
        if(stack.pop().intValue() == minValue.peek().intValue()){
            minValue.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
