//[104]二叉树的最大深度
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 905 👎 0

package com.titan.leetcode.editor.cn;
public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
       Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxDepth(TreeNode root) {
            // 递归
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//            return maxDepthTree(root, 0);
        }

//        private int maxDepthTree(TreeNode root, int level) {
//            if (root == null){
//                return level;
//            }
//
//            int lDepth = maxDepthTree(root.left, level + 1);
//            int rDepth = maxDepthTree(root.right, level + 1);
//
//            return lDepth > rDepth ? lDepth : rDepth;
//        }
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