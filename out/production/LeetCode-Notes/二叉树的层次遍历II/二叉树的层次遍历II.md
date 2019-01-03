## 107. 二叉树的层次遍历 II（Binary Tree Level Order Traversal II）  
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

      3    
     / \
    9  20
      /  \
     15   7
 返回其自底向上的层次遍历为：

    [
       [15,7],
       [9,20],
       [3]
    ]

分析：  
从上到下，从左到右，遍历每一层。  
从根节点开始，将当前层每个节点值保存在curValues中，同时将当前层所有节点的左右子节点放入next作为下一层，然后cur指向下一层继续遍历知道cur为空。

代码：
```java
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
```