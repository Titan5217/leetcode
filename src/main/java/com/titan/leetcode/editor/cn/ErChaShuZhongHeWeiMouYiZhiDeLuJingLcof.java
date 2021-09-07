//[剑指 Offer 34]二叉树中和为某一值的路径
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 228 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            // dfs
            dfs(root, target);
            return retList;
        }

        private void dfs(TreeNode currentNode, int target) {
            if (null == currentNode){
                return;
            }
            path.add(currentNode.val);

            target -= currentNode.val;
            if (currentNode.left == null && currentNode.right == null && target == 0){
                retList.add(new ArrayList(path));
            }

            dfs(currentNode.left, target);
            dfs(currentNode.right, target);
            path.remove(path.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}