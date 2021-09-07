//[剑指 Offer 32 - II]从上到下打印二叉树 II
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 131 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args) {
       Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> retList = new ArrayList<>();
            if(root == null){
                return retList;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                List<Integer> tmpList = new ArrayList<>();
                for (int i = queue.size(); i > 0 ; i--) {
                    TreeNode tmpTreeNode = queue.poll();
                    tmpList.add(tmpTreeNode.val);
                    if (tmpTreeNode.left != null){
                        queue.add(tmpTreeNode.left);
                    }
                    if (tmpTreeNode.right != null){
                        queue.add(tmpTreeNode.right);
                    }
                }
                retList.add(tmpList);
            }
            return retList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}