//[863]二叉树中所有距离为 K 的结点
//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 331 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        Map<TreeNode, Integer> map = new HashMap<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // DFS
            List<Integer> retList = new ArrayList<>();

            find(root, target);
            dfs(root, k, map.get(root), retList);

            return retList;
        }

        private void dfs(TreeNode currentNode, int k, int depth, List<Integer> retList) {
            if (currentNode == null){
                return;
            }

            depth = map.getOrDefault(currentNode, depth);

            if (k == depth){
                retList.add(currentNode.val);
            }

            dfs(currentNode.left, k, depth + 1, retList);
            dfs(currentNode.right, k, depth + 1, retList);
        }

        private int find(TreeNode currentNode, TreeNode target) {
            if (currentNode == null){
                return -1;
            }

            if (currentNode.val == target.val){
                map.put(currentNode, 0);
                return 0;
            }

            int retVal = find(currentNode.left, target);
            if (retVal >= 0){
                map.put(currentNode, retVal + 1);
                return retVal + 1;
            }

            retVal = find(currentNode.right, target);
            if (retVal >= 0){
                map.put(currentNode, retVal + 1);
                return retVal + 1;
            }

            return -1;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}