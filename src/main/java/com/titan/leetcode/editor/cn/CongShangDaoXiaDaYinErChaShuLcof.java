//[剑指 Offer 32 - I]从上到下打印二叉树
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 120 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
       Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] levelOrder(TreeNode root) {
            // bfs
            if(root == null) return new int[0];
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<Integer> tmpList = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode tmpTreeNode = queue.poll();
                tmpList.add(tmpTreeNode.val);
                if (tmpTreeNode.left != null){
                    queue.add(tmpTreeNode.left);
                }
                if (tmpTreeNode.right != null){
                    queue.add(tmpTreeNode.right);
                }
            }
            int[] ans = new int[tmpList.size()];
            for (int i = 0; i < tmpList.size(); i++) {
                ans[i] = tmpList.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}