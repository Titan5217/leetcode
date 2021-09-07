//[剑指 Offer 33]二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 333 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Stack;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
       Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            // solution1
//            return recursion(postorder, 0, postorder.length - 1);
            // solution2
            return solution2(postorder);
        }

        private boolean solution2(int[] postorder) {
            Stack<Integer> stack = new Stack<>();
            int tmp = Integer.MAX_VALUE;
            for (int i = postorder.length - 1; i >= 0; i--) {
                if (postorder[i] > tmp){
                    return false;
                }
                while (!stack.isEmpty() && stack.peek() > postorder[i]){
                    tmp = stack.pop();
                }
                stack.push(postorder[i]);
            }
            return true;
        }

//        private boolean recursion(int[] postorder, int i, int j) {
//            if (i >= j){
//                return true;
//            }
//
//            int p = i;
//            while (postorder[p] < postorder[j]){
//                p ++;
//            }
//            int m = p;
//            while (postorder[p] > postorder[j]){
//                p ++;
//            }
//            return p == j && recursion(postorder, i, m - 1) && recursion(postorder, m, j - 1);
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}