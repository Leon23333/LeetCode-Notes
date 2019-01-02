package 用栈实现队列;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> temp;
    Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        temp = new Stack<>();
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    //为了让每次能弹出最先添加的元素，push时必须将元素添加到栈底，
    //因此可以用一个临时栈保存栈中元素，将x插入栈底后再将临时栈中的元素插入栈中
    public void push(int x) {
        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }
        stack.push(x);
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    //只需弹出stack栈顶元素即可
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
