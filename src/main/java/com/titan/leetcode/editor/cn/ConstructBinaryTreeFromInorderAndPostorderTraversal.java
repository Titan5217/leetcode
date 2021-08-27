//[106]从中序与后序遍历序列构造二叉树
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 554 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int[] post;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
            post = postorder;
            TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
            return root;
        }

        public TreeNode buildTree(int is, int ie, int ps, int pe) {
            if(ie < is || pe < ps) return null;

            int root = post[pe];
            int ri = memo.get(root);

            TreeNode node = new TreeNode(root);
            node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
            node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}