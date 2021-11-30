//[869]重新排序得到 2 的幂
//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：true
// 
//
// 示例 2： 
//
// 输入：10
//输出：false
// 
//
// 示例 3： 
//
// 输入：16
//输出：true
// 
//
// 示例 4： 
//
// 输入：24
//输出：false
// 
//
// 示例 5： 
//
// 输入：46
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 计数 枚举 排序 
// 👍 70 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOf2{
  public static void main(String[] args) {
       Solution solution = new ReorderedPowerOf2().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      static Set<Integer> set = new HashSet<>();
      static {
          for (int i = 1; i < (int)1e9+10; i *= 2) set.add(i);
      }
      int m;
      int[] cnts = new int[10];
      public boolean reorderedPowerOf2(int n) {
          while (n != 0) {
              cnts[n % 10]++;
              n /= 10;
              m++;
          }
          return dfs(0, 0);
      }
      boolean dfs(int u, int cur) {
          if (u == m) return set.contains(cur);
          for (int i = 0; i < 10; i++) {
              if (cnts[i] != 0) {
                  cnts[i]--;
                  if ((i != 0 || cur != 0) && dfs(u + 1, cur * 10 + i)) return true;
                  cnts[i]++;
              }
          }
          return false;
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}