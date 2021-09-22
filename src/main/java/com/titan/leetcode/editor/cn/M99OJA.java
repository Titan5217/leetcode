//[剑指 Offer II 086]分割回文子字符串
//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]  
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 字符串 动态规划 回溯 
// 👍 5 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M99OJA{
    public static void main(String[] args) {
       Solution solution = new M99OJA().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> retList = new ArrayList<>();
        public String[][] partition(String s) {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                Arrays.fill(dp[i], true);
            }
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }

            dfs(s, dp, 0, length, new LinkedList<>());

            String[][] ans = new String[retList.size()][];
            for (int i = 0; i < retList.size(); i++) {
                ans[i] = new String[retList.get(i).size()];
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j] = retList.get(i).get(j);
                }
            }
            return ans;
        }

        private void dfs(String s, boolean[][] dp, int index, int length, LinkedList<String> path) {
            if (index == length){
                retList.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < length; i++) {
                if (dp[index][i]){
                    path.addLast(s.substring(index, i + 1));
                    dfs(s, dp, i + 1, length, path);
                    path.removeLast();
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}