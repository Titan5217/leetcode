//[226]翻转二叉树
//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 891 👎 0

package com.titan.leetcode.editor.cn;

import apple.laf.JRSUIUtils;

import java.util.Stack;

public class InvertBinaryTree{
    public static void main(String[] args) {
       Solution solution = new InvertBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            // 递归，左变右，右变左
//            // 结束标识
//            if (root == null){
//                return root;
//            }
//            // 当前层级逻辑
//            TreeNode tmpNode = root.left;
//            root.left = root.right;
//            root.right = tmpNode;
//
//            // 下一层级
//            invertTree(root.left);
//            invertTree(root.right);
//            // 组装返回值
//            return root;

            // 迭代
            if (root == null){
                return root;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode currentNode = stack.pop();

                TreeNode left = currentNode.left;
                TreeNode right = currentNode.right;

                currentNode.left = right;
                currentNode.right = left;

                if (left != null){
                    stack.push(left);
                }
                if (right != null){
                    stack.push(right);
                }
            }

            return root;
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