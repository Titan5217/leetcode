//[剑指 Offer II 085]生成匹配的括号
//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
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
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 
// 👍 3 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IDBivT{
    public static void main(String[] args) {
       Solution solution = new IDBivT().new Solution();
        solution.generateParenthesis(3);
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            // dfs
            dfs(0, 0, n, "");
            return ans;
        }

        List<String> ans = new ArrayList<>();
        private void dfs(int leftCount, int rightCount, int n, String path) {
            if (leftCount == n && rightCount == n){
                ans.add(path);
                return;
            }

            if (leftCount < n){
                dfs(leftCount + 1, rightCount, n, path + "(");
            }
            if (rightCount < leftCount){
                dfs(leftCount, rightCount + 1, n, path + ")");
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}