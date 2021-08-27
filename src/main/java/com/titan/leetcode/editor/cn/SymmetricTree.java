//[101]对称二叉树
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1495 👎 0

package com.titan.leetcode.editor.cn;
public class SymmetricTree{
    public static void main(String[] args) {
       Solution solution = new SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null){
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode oneNode, TreeNode otherNode) {
            if (oneNode == null || otherNode == null){
                return oneNode == otherNode;
            }
            if (oneNode.val != otherNode.val){
                return false;
            }
            return isSymmetric(oneNode.left, otherNode.right) && isSymmetric(oneNode.right, otherNode.left);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}