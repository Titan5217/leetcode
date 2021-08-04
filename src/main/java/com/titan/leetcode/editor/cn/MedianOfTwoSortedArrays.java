//[4]寻找两个正序数组的中位数
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4307 👎 0

package com.titan.leetcode.editor.cn;
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 合并成一个数组，取得对应的下标位置

            // 确认所要取得的数据的下标，双指针进行查找

            // 二分查找，第k小的数
            return erfen(nums1, nums2);

        }

        private double erfen(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 0){
                int mid1 = totalLength / 2 - 1, mid2 = totalLength / 2;
                double median = (fetchValue(nums1, nums2, mid1 + 1) + fetchValue(nums1, nums2, mid2 + 1)) / 2.0;
                return median;
            } else {
                int mid = totalLength / 2;
                double median = fetchValue(nums1, nums2, mid + 1);
                return median;
            }
        }

        private double fetchValue(int[] nums1, int[] nums2, int k) {
            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kValue = 0;
            while(true){
                if (length1 == index1){
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }

                if (k == 1){
                    return Math.min(nums1[index1], nums2[index2]);
                }

                int half = k / 2;
                int newIndex1 = Math.min(half + index1, length1) - 1;
                int newIndex2 = Math.min(half + index2, length2) - 1;
                int value1 = nums1[newIndex1], value2 = nums2[newIndex2];
                if (value1 <= value2){
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}