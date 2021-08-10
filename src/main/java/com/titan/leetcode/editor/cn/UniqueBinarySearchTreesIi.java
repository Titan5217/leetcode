//[95]不同的二叉搜索树 II
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 955 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
       Solution solution = new UniqueBinarySearchTreesIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            // 分治
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int left, int right) {
            List<TreeNode> retList = new ArrayList<>();
            if (left > right){
                retList.add(null);
                return retList;
            }

            for (int i = left; i <= right ; i++) {
                List<TreeNode> leftNodeList = generateTrees(left, i - 1);
                List<TreeNode> rightNodeList = generateTrees(i + 1, right);

                for (int j = 0; j < leftNodeList.size(); j++) {
                    for (int k = 0; k < rightNodeList.size(); k++) {
                        retList.add(new TreeNode(i, leftNodeList.get(j), rightNodeList.get(k)));
                    }
                }
            }

            return retList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}