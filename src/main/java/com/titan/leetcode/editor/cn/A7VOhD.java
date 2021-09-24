//[剑指 Offer II 020]回文子字符串的个数
//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 
// 👍 6 👎 0

package com.titan.leetcode.editor.cn;
public class A7VOhD{
    public static void main(String[] args) {
       Solution solution = new A7VOhD().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            // dp
            return dp(s);
        }

        private int dp(String s) {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int count = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])){
                        dp[j][i] = true;
                        count ++;
                    }
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}