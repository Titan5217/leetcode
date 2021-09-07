//[剑指 Offer 51]数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 510 👎 0

package com.titan.leetcode.editor.cn;
public class ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
       Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        public int reversePairs(int[] nums) {
            // 归并
            sort(nums, 0, nums.length - 1, new int[nums.length]);
            return ans;
        }

        private void sort(int[] nums, int left, int right, int[] arrays) {
            if (left <  right){
                int mid = (right - left) / 2 + left;
                sort(nums, left, mid, arrays);
                sort(nums, mid + 1, right, arrays);
                merge(nums, left, mid, right, arrays);
            }
        }

        private void merge(int[] nums, int left, int mid, int right, int[] arrays) {
            int i = left;
            int j = mid + 1;
            int t = 0;

            while(i <=mid && j <=right){
                if(nums[i] <= nums[j]){
                    arrays[t++] = nums[i++];
                }else{
                    ans += (mid - i + 1);
                    arrays[t++] = nums[j++];
                }
            }

            while (i <= mid){
                arrays[t++] = nums[i++];
            }
            while( j <= right){
                arrays[t++] = nums[j++];
            }

            t = 0;
            while (left <=right){
                nums[left++] = arrays[t++];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}