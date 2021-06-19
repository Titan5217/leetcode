//[94]二叉树的中序遍历
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 992 👎 0

package com.titan.leetcode.editor.cn;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // 递归
//            List<Integer> list = new ArrayList<>();
//
//            inorder(root, list);
//
//            return list;

            //迭代
//            List<Integer> list = new ArrayList<>();
//            Stack<TreeNode> stack = new Stack<>();
//
//            while (root != null || !stack.isEmpty()){
//                while (root != null){
//                    stack.push(root);
//                    root = root.left;
//                }
//                root = stack.pop();
//                list.add(root.val);
//                root = root.right;
//            }

//            return list;

            // 莫里斯
//            List<Integer> list = new ArrayList<>();
//            TreeNode predecessor = null; //当前节点的前一个节点
//
//            while (root != null){
//                if (root.left != null){
//                    //左走一步，然后一路向右，取得当前节点前的最后一个节点
//                    predecessor = root.left;
//                    while (predecessor != null && predecessor.right != root){
//                        predecessor = predecessor.right;
//                    }
//
//                    //predecessor已是最右的节点，确认此节点是否有左子树
//                    if (predecessor.right == null){
//                        predecessor.right = root;
//                        root = root.left;
//                    } else {
//                        //
//                        list.add(root.val);
//                        predecessor.right = null;
//                        root = root.right;
//                    }
//                } else {
//                    list.add(root.val);
//                    root = root.right;
//                }
//            }
//
//            return list;
        }

        private void inorder(TreeNode root, List<Integer> list) {
            if (null == root){
                return;
            }

            // 左中右
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
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