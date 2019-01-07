package Stack.二叉搜索树迭代器;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/*
二叉搜索树：
1.若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
2.若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
3.它的左、右子树也分别为二叉排序树。

对二叉搜索树做中序遍历就可以得到从小到大的值，可以用递归或栈实现
 */
class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> stack;
    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        queue = new LinkedBlockingQueue<>();
        inOrder(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void inOrder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                queue.add(cur.val);
                cur = cur.right;
            }
        }
    }
}
