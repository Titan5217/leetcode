//[剑指 Offer 54]二叉搜索树的第k大节点
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 198 👎 0

package com.titan.leetcode.editor.cn;
public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
       Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int k;
        int ans;
        public int kthLargest(TreeNode root, int k) {
            // 二叉搜索树，反向中序遍历
            this.k = k;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode currentNode) {
            if (currentNode == null){
                return;
            }
            dfs(currentNode.right);
            if (k == 0){
                return;
            }
            if (--k == 0){
                ans = currentNode.val;
            }
            dfs(currentNode.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}