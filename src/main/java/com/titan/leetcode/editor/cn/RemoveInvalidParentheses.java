//[301]删除无效的括号
//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 
// 👍 589 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses{
  public static void main(String[] args) {
       Solution solution = new RemoveInvalidParentheses().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      Set<String> set = new HashSet<>();
      int n, max, len;
      String s;
      public List<String> removeInvalidParentheses(String _s) {
          s = _s;
          n = s.length();

          int l = 0, r = 0;
          for (char c : s.toCharArray()) {
              if (c == '(') {
                  l++;
              } else if (c == ')') {
                  if (l != 0) l--;
                  else r++;
              }
          }
          len = n - l - r;

          int c1 = 0, c2 = 0;
          for (char c : s.toCharArray()) {
              if (c == '(') c1++;
              else if (c == ')') c2++;
          }
          max = Math.min(c1, c2);

          dfs(0, "", l, r, 0);
          return new ArrayList<>(set);
      }
      void dfs(int u, String cur, int l, int r, int score) {
          if (l < 0 || r < 0 || score < 0 || score > max) return ;
          if (l == 0 && r == 0) {
              if (cur.length() == len) set.add(cur);
          }
          if (u == n) return ;
          char c = s.charAt(u);
          if (c == '(') {
              dfs(u + 1, cur + String.valueOf(c), l, r, score + 1);
              dfs(u + 1, cur, l - 1, r, score);
          } else if (c == ')') {
              dfs(u + 1, cur + String.valueOf(c), l, r, score - 1);
              dfs(u + 1, cur, l, r - 1, score);
          } else {
              dfs(u + 1, cur + String.valueOf(c), l, r, score);
          }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}