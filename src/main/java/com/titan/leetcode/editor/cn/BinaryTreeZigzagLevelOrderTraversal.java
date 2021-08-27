//[103]二叉树的锯齿形层序遍历
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 501 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> retList = new ArrayList<>();
            if (null == root){
                return retList;
            }

            // FBS
            bfs(root, retList, 1);

            return retList;
        }

        private void bfs(TreeNode currentNode, List<List<Integer>> retList, int level) {
            if (retList.size() < level){
                retList.add(new ArrayList<>());
            }

            if (level % 2 == 1){
                retList.get(level - 1).add(currentNode.val);
            } else {
                retList.get(level - 1).add(0, currentNode.val);
            }

            if (currentNode.left != null){
                bfs(currentNode.left, retList, level + 1);
            }
            if (currentNode.right != null){
                bfs(currentNode.right, retList, level + 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}