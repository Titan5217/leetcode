//[102]二叉树的层序遍历
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 906 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (null == root){
                return list;
            }

            // 递归，广度优先s
            bfs(root, list, 1);

            // 递归，深度优先
            // 非递归两种方式

            return list;
        }

        private void bfs(TreeNode root, List<List<Integer>> list, int level) {
            if (list.size() < level){
                list.add(new ArrayList<>());
            }

            list.get(level - 1).add(root.val);
            if (root.left != null){
                bfs(root.left, list, level + 1);
            }
            if (root.right != null){
                bfs(root.right, list, level + 1);
            }
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