//[718]最长重复子数组
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 506 👎 0

package com.titan.leetcode.editor.cn;
public class MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // 最长公共子序列,需求是连续
            return solution1(nums1, nums2);
        }

        private int solution1(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int[][] dp = new int[length1 + 1][length2 + 1];
            int ans = 0;
            for (int i = 1; i <= length1; i++) {
                for (int j = 1; j <= length2 ; j++) {
                    dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}