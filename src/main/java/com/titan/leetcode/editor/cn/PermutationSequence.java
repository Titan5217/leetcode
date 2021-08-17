//[60]排列序列
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 555 👎 0

package com.titan.leetcode.editor.cn;
public class PermutationSequence{
    public static void main(String[] args) {
       Solution solution = new PermutationSequence().new Solution();
        solution.getPermutation(3, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String retValue;
        int successCount = 0;
        public String getPermutation(int n, int k) {
            // dfs
            StringBuffer buffer = new StringBuffer();
            boolean[] used = new boolean[n + 1];

            dfs(n, k, 0, buffer, used);
            return retValue;
        }

        private void dfs(int n, int needCount, int index, StringBuffer buffer, boolean[] used) {
            if (index == n){
                if (needCount == ++successCount){
                    retValue = buffer.toString();
                }
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (needCount == successCount){
                    break;
                }
                if (!used[i]){
                    used[i] = true;
                    buffer.append(i);
                    dfs(n, needCount, index + 1, buffer, used);
                    buffer.deleteCharAt(buffer.length() - 1);
                    used[i] = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}