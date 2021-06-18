//[88]合并两个有序数组
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 972 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray{
    public static void main(String[] args) {
       Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //追加排序
//            执行耗时:1 ms,击败了24.98% 的Java用户
//            内存消耗:38.5 MB,击败了65.74% 的Java用户
//            System.arraycopy(nums2, 0, nums1, m, n);
//            Arrays.sort(nums1);

            // 临时表
//            执行耗时:0 ms,击败了100.00% 的Java用户
//            内存消耗:38.6 MB,击败了30.28% 的Java用户
//            int p1 = 0;
//            int p2 = 0;
//            int[] tmpArray = new int[m + n];
//            int curr;
//            while(p1 < m || p2 < n){
//                if (p1 >= m){
//                    curr = nums2[p2 ++];
//                } else if (p2 >= n){
//                    curr = nums1[p1 ++];
//                } else if (nums1[p1] < nums2[p2]){
//                    curr = nums1[p1++];
//                } else {
//                    curr = nums2[p2++];
//                }
//                tmpArray[p1 + p2 - 1] = curr;
//            }
//
//            System.arraycopy(tmpArray, 0, nums1, 0, m + n);

            // 反向指针
//            执行耗时:0 ms,击败了100.00% 的Java用户
//            内存消耗:38.5 MB,击败了56.74% 的Java用户
//            int nums1Offset = m - 1;
//            int nums2Offset = n - 1;
//            int position = m + n - 1;
//            int curr;
//            while (nums1Offset >= 0 || nums2Offset >= 0){
//                if (nums1Offset == -1) {
//                    curr = nums2[nums2Offset--];
//                } else if (nums2Offset == -1) {
//                    curr = nums1[nums1Offset--];
//                } else if (nums1[nums1Offset] > nums2[nums2Offset]) {
//                    curr = nums1[nums1Offset--];
//                } else {
//                    curr = nums2[nums2Offset--];
//                }
//                nums1[position--] = curr;
//            }

            // 国际站最牛写法一
//            执行耗时:0 ms,击败了100.00% 的Java用户
//            内存消耗:38.4 MB,击败了73.06% 的Java用户
//            int p1 = m - 1;
//            int p2 = n - 1;
//            int position = m + n - 1;
//            while (p1 >= 0 && p2 >= 0){
//                if (nums1[p1] > nums2[p2]){
//                    nums1[position--] = nums1[p1--];
//                } else {
//                    nums1[position--] = nums2[p2--];
//                }
//            }
//            while (p2 >= 0){
//                nums1[position--] = nums2[p2--];
//            }

            // 国际站最牛写法二
//            执行耗时:0 ms,击败了100.00% 的Java用户
//            内存消耗:38.6 MB,击败了49.57% 的Java用户
            while (n > 0){
                if (m <= 0 || nums2[n-1] >= nums1[m-1]){
                    nums1[m+n-1] = nums2[--n];
                } else {
                    nums1[m+n-1] = nums1[--m];
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}