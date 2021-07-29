//[32]最长有效括号
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1367 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Stack;

public class LongestValidParentheses{
    public static void main(String[] args) {
       Solution solution = new LongestValidParentheses().new Solution();
        solution.longestValidParentheses(")()())");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            // DP
//            return dp(s);
            // stack
            return stack(s);
        }

        private int stack(String s) {
            if (null == s || s.length() == 0){
                return 0;
            }

            int length = s.length();
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int returnLength = 0;

            for (int i = 0; i < length; i++) {
                if (s.charAt(i) == '('){
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()){
                        stack.push(i);
                    } else {
                        returnLength = Math.max(returnLength, i - stack.peek());
                    }
                }
            }

            return returnLength;
        }

        private int dp(String s) {
            if (null == s || s.length() == 0){
                return 0;
            }

            int length = s.length();

            int[] dp = new int[length];
            int returnLength = 0;
            for (int i = 1; i < length; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }

                    returnLength = Math.max(returnLength, dp[i]);
                }
            }

            return returnLength;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}