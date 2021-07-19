//[647]回文子串
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 630 👎 0

package com.titan.leetcode.editor.cn;
public class PalindromicSubstrings{
    public static void main(String[] args) {
       Solution solution = new PalindromicSubstrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            // 中心扩展
            // dp
            return dp(s);
        }

        private int dp(String s) {
            // dp[i][j] 从i到j是否为回文串
            // j - i > 2; dp[i][j] = dp[i + 1][j - 1] && (s[i] == s[j]);
            int length = s.length();
            int count = 0;
            boolean[][] dp = new boolean[length][length];
            for (int j = 0; j < length; j++) {
                for (int i = 0; i <= j; i ++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])){
                        dp[i][j] = true;
                        count ++;
                    }
                }
            }

            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}