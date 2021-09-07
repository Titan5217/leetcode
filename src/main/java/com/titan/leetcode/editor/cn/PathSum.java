//[112]路径总和
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 645 👎 0

package com.titan.leetcode.editor.cn;
public class PathSum{
    public static void main(String[] args) {
       Solution solution = new PathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root, targetSum);
        }

        private boolean dfs(TreeNode currentNode, int targetSum) {
            if (currentNode == null){
                return false;
            }

            if (currentNode.left == null && currentNode.right == null ){
                return targetSum == currentNode.val;
            }

            return dfs(currentNode.left, targetSum - currentNode.val) || dfs(currentNode.right, targetSum - currentNode.val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}