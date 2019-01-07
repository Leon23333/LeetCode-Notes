package Stack.二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

//递归实现
public class Solution2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null){
            return list;
        }
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode root) {
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
