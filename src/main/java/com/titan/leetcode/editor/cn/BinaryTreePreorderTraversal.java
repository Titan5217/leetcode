//[144]二叉树的前序遍历
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 579 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            // 迭代
            List<Integer> list = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()){
                while (root != null){
                    stack.push(root);
                    list.add(root.val);
                    root = root.left;
                }

                root = stack.pop();
                root = root.right;
            }

            return list;

            // 递归
//            List<Integer> list = new ArrayList<>();
//
//            preorder(root, list);
//
//            return list;
        }

        private void preorder(TreeNode root, List<Integer> list) {
            if (root == null){
                return ;
            }

            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
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