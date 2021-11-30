//[1218]最长定差子序列
//给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 differen
//ce 。 
//
// 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4], difference = 1
//输出：4
//解释：最长的等差子序列是 [1,2,3,4]。 
//
// 示例 2： 
//
// 
//输入：arr = [1,3,5,7], difference = 1
//输出：1
//解释：最长的等差子序列是任意单个元素。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
//输出：4
//解释：最长的等差子序列是 [7,5,3,1]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 105 
// -104 <= arr[i], difference <= 104 
// 
// Related Topics 数组 哈希表 动态规划 
// 👍 134 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference{
  public static void main(String[] args) {
       Solution solution = new LongestArithmeticSubsequenceOfGivenDifference().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] f = new int[n][2];
        f[0][1] = 1;
        map.put(arr[0], 0);
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = 1;
            int prev = arr[i] - difference;
            if (map.containsKey(prev)) f[i][1] = Math.max(f[i][1], f[map.get(prev)][1] + 1);
            map.put(arr[i], i);
        }
        return Math.max(f[n - 1][0], f[n - 1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}