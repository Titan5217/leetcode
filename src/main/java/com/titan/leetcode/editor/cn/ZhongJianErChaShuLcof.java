//[剑指 Offer 07]重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
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
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 550 👎 0

package com.titan.leetcode.editor.cn;
public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
       Solution solution = new ZhongJianErChaShuLcof().new Solution();
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