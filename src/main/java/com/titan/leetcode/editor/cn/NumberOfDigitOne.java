//[233]数字 1 的个数
//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 281 👎 0

package com.titan.leetcode.editor.cn;
public class NumberOfDigitOne{
    public static void main(String[] args) {
       Solution solution = new NumberOfDigitOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            // dp
            // 暴力
            // 数据
            return solution1(n);
        }

        private int solution1(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i *= 10) {
                ans += (n / (i * 10)) * i + Math.min(Math.max(n % (i * 10) - i + 1,0), i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}