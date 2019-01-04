package Stack.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    private List<Integer> list = new ArrayList<>();

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
