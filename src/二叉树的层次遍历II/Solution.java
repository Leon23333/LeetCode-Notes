package 二叉树的层次遍历II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        //当前层节点
        List<TreeNode> cur = new ArrayList<>();
        //从根节点开始遍历
        cur.add(root);
        while (!cur.isEmpty()){
            //用于保存当前层所有节点的值
            List<Integer> curValues = new ArrayList<>();
            //下一层节点
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode curNode: cur) {
                //保存当前节点的值
                curValues.add(curNode.val);
                //将左右子节点记录到下一层list
                if (curNode.left!=null){
                    next.add(curNode.left);
                }
                if (curNode.right!=null){
                    next.add(curNode.right);
                }
            }
            result.add(0,curValues);
            //移向下一层
            cur = next;
        }
        return result;
    }
}
