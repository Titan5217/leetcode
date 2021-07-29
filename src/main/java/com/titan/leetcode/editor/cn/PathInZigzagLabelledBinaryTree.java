//[1104]二叉树寻路
//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 
// 👍 109 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree{
    public static void main(String[] args) {
       Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
        solution.pathInZigZagTree(26);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            int level = 1;
            while((Math.pow(2,level) - 1) < label){
                level++;
            }
            int[] ans = new int[level];
            int idx = level - 1, cur = label;
            while (idx >= 0) {
                ans[idx--] = cur;
                int loc = ((1 << level) - 1 - cur) >> 1;
                cur = (1 << (level - 2)) + loc;
                level--;
            }
            List<Integer> list = new ArrayList<>();
            for (int i : ans) list.add(i);
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}