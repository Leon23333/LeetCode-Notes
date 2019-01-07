package Stack.二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//栈实现
public class Solution1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历栈方式
     * 每次输出根节点，再输出左节点和右节点。步骤如下：
     * 1、若栈非空输出根节点，并出栈
     * 2、将右节点压栈（如果存在）
     * 3、将左节点压栈（如果存在）
     * 4、重复第1步直到栈空
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return list;
    }
}
