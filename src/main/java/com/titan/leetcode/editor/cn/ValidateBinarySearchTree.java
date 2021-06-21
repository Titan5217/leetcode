//[98]验证二叉搜索树
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1101 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Stack;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
       Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            // 迭代先序遍历
            return iteratorInOrder(root);
            // 递归先序遍历，看是否递增
//            return recursionInOrder(root);
            // 递归
//            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean iteratorInOrder(TreeNode root) {
            if (root == null){
                return true;
            }

            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= pre){
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
            return true;
        }

        private boolean recursionInOrder(TreeNode root) {
            if (root == null){
                return true;
            }

            if (!recursionInOrder(root.left)){
                return false;
            }

            if (root.val <= pre){
                return false;
            }
            pre = root.val;

            return recursionInOrder(root.right);
        }

        public boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}