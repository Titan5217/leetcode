//[剑指 Offer 32 - III]从上到下打印二叉树 III
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 二叉树 
// 👍 127 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
       Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
                LinkedList<Integer> tmpList = new LinkedList<>();
                for (int i = queue.size(); i > 0 ; i--) {
                    TreeNode tmpTreeNode = queue.poll();
                    if (retList.size() % 2 == 0){
                        tmpList.addLast(tmpTreeNode.val);
                    } else {
                        tmpList.addFirst(tmpTreeNode.val);
                    }
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