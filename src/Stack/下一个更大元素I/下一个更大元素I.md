## 496. 下一个更大元素 I（Next Greater Element I）  
给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

示例 1:

    输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出: [-1,3,-1]
    解释:
        对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
        对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
        对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
示例 2:

    输入: nums1 = [2,4], nums2 = [1,2,3,4].
    输出: [3,-1]
    解释:
        对于num1中的数字2，第二个数组中的下一个较大数字是3。
        对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
    
注意:

- 1.nums1和nums2中所有元素是唯一的。  
- 2.nums1和nums2 的数组大小都不超过1000。

代码：
```java
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
```