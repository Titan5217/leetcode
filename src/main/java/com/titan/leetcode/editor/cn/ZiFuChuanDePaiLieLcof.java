//[剑指 Offer 38]字符串的排列
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 408 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
       Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
       solution.permutation("abbc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            // 排序
            return solution1(s.toCharArray());
        }

        List<String> retList;
        boolean[] visited;
        private String[] solution1(char[] charArray) {
            int length = charArray.length;
            retList = new ArrayList<>();
            visited = new boolean[length];
            Arrays.sort(charArray);
            dfs(charArray, 0, "");
            return retList.toArray(new String[retList.size()]);
        }

        private void dfs(char[] charArray, int index, String path) {
            int length = charArray.length;
            if (index == length){
                retList.add(path);
                System.out.println(path);
                return;
            }
            for (int i = 0; i < length; i++) {
                if (i > 0 && !visited[i - 1] && charArray[i] == charArray[i - 1]) continue;
                if (!visited[i]){
                    visited[i] = true;
                    dfs(charArray, index + 1, path + charArray[i]);
                    visited[i] = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}