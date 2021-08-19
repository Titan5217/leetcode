//[75]颜色分类
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 
// 👍 976 👎 0

package com.titan.leetcode.editor.cn;
public class SortColors{
    public static void main(String[] args) {
       Solution solution = new SortColors().new Solution();
        solution.sortColors(new int[]{0,1,0,0,0,2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            solution1(nums);
        }

        private void solution1(int[] nums) {
            int length = nums.length;
            int p0 = 0, p2 = length - 1;
            for (int i = 0; i <= p2; i++) {
                while (i < p2 && nums[i] == 2){
                    swap(nums, i, p2);
                    p2 --;
                }
                if (nums[i] == 0){
                    if (i > p0){
                        swap(nums, i, p0);
                    }
                    p0 ++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}