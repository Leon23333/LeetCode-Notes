package Stack.下一个更大元素I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //单调栈实现
        //使用一个stack和一个hashMap实现
        //遍历数组nums2，将每个元素入栈。入栈前先比较，当待入栈元素小于等于栈顶元素时，直接入栈，
        // 当待入栈元素大于栈顶元素时，此时待入栈元素即为栈顶元素后面的第一个比它大的元素，将两个值存入map中，并将栈顶元素出栈，
        // 继续比较栈顶元素和待入栈元素，直到待入栈元素小于等于栈顶元素时，待入栈元素入栈。
        //栈中元素从栈底到栈顶是从大到小的
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}