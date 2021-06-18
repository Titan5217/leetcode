//[189]旋转数组
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 986 👎 0

package com.titan.leetcode.editor.cn;
public class RotateArray{
    public static void main(String[] args) {
       Solution solution = new RotateArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            // 翻转
//            k %= nums.length;
//            reverse(nums, 0, nums.length - 1);
//            reverse(nums, 0, k - 1);
//            reverse(nums, k, nums.length - 1);

            // 旋转,进行K次旋转，没太看懂
//            int n = nums.length;
//            k = k % n;
//            int count = gcd(k, n);
//            for (int start = 0; start < count; ++start) {
//                int current = start;
//                int prev = nums[start];
//                do {
//                    int next = (current + k) % n;
//                    int temp = nums[next];
//                    nums[next] = prev;
//                    prev = temp;
//                    current = next;
//                } while (start != current);
//            }

            // 迭代
//            int length = nums.length;
//            int[] tmpNums = new int[length];
//            for (int i = 0; i < length; i++) {
//                tmpNums[(i + k) % length] = nums[i];
//            }
//
//            System.arraycopy(tmpNums, 0, nums, 0, length);

        }

        private int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}