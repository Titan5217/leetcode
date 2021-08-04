//[5]最长回文子串
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3896 👎 0

package com.titan.leetcode.editor.cn;

import java.lang.reflect.GenericDeclaration;

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
       solution.longestPalindrome("babad");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 中心扩展
            return centerAround(s);
            // dp
//            return dp(s);
        }

        private String dp(String s) {
            // boolean[i][j] dp
            // i~j 是否为回文
            // s.charAt(i) = s.charAt(j) ?
            //      (j - i < 3 ?  dp[i][j] = true : dp[i][j] = dp[i + 1][j - 1]): dp[i][j] = false
            return "";
        }

        private String centerAround(String s) {
            if (s == null || s.length() == 0){
                return "";
            }

            int start = 0;
            int end = 0;

            for (int i = 0; i < s.length(); i++) {
                int len1 = isArountCenter(s, i, i);
                int len2 = isArountCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start){
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int isArountCenter(String s, int index1, int index2) {
            int l = index1, r = index2;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l --;
                r ++;
            }
            return r - l - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}