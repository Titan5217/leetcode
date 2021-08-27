//[131]分割回文串
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 814 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args) {
       Solution solution = new PalindromePartitioning().new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> retList = new ArrayList<>();
        public List<List<String>> partition(String s) {
            int length = s.length();
            // 标记从i到j是否为回文
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                Arrays.fill(dp[i], true);
            }
            for (int i = length - 1; i >= 0 ; i--) {
                for (int j = i + 1; j < length; j++) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }

            dfs(s, dp, 0, length, new ArrayList());

            return retList;
        }

        private void dfs(String s, boolean[][] dp, int i, int length, ArrayList path) {
            if (i == length){
                retList.add(new ArrayList<String>(path));
                return;
            }
            for (int j = i; j < length; j++) {
                if (dp[i][j]){
                    path.add(s.substring(i, j + 1));
                    dfs(s, dp, j + 1, length, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}