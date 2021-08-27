//[105]从前序与中序遍历序列构造二叉树
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1172 👎 0

package com.titan.leetcode.editor.cn;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
       Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeHelper(preorder,  inorder, (long)Integer.MAX_VALUE + 1);
        }
        int pre = 0;
        int in = 0;
        private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
            //到达末尾返回 null
            if(pre == preorder.length){
                return null;
            }
            //到达停止点返回 null
            //当前停止点已经用了，in 后移
            if (inorder[in] == stop) {
                in++;
                return null;
            }
            int root_val = preorder[pre++];
            TreeNode root = new TreeNode(root_val);
            //左子树的停止点是当前的根节点
            root.left = buildTreeHelper(preorder,  inorder, root_val);
            //右子树的停止点是当前树的停止点
            root.right = buildTreeHelper(preorder, inorder, stop);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}