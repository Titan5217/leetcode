//[剑指 Offer 56 - I]数组中数字出现的次数
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 460 👎 0

package com.titan.leetcode.editor.cn;
public class ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
       Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int ret = 0;
            for (int n : nums) {
                ret ^= n;
            }
            int div = 1;
            while ((div & ret) == 0) {
                div <<= 1;
            }
            int a = 0, b = 0;
            for (int n : nums) {
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};

            // 神逻辑，拿来膜拜一下
//            int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
//            for (int num: nums) {
//                if (num == 0) {
//                    zeroCount += 1;
//                }
//                min = Math.min(min, num);
//                max = Math.max(max, num);
//                sum ^= num;
//            }
//            // 需要特判一下某个数是0的情况。
//            if (zeroCount == 1) {
//                return new int[]{sum, 0};
//            }
//            int lo = min, hi = max;
//            while (lo <= hi) {
//                // 根据 lo 的正负性来判断二分位置怎么写，防止越界。
//                int mid = (lo < 0 && hi > 0)? (lo + hi) >> 1: lo + (hi - lo) / 2;
//                int loSum = 0, hiSum = 0;
//                for (int num: nums) {
//                    if (num <= mid) {
//                        loSum ^= num;
//                    } else {
//                        hiSum ^= num;
//                    }
//                }
//                if (loSum != 0 && hiSum != 0) {
//                    // 两个都不为0，说明 p 和 q 分别落到2个数组里了。
//                    return new int[] {loSum, hiSum};
//                }
//                if (loSum == 0) {
//                    // 说明 p 和 q 都比 mid 大，所以比 mid 小的数的异或和变为0了。
//                    lo = mid + 1;
//                } else {
//                    // 说明 p 和 q 都不超过 mid
//                    hi = mid - 1;
//                }
//            }
//            // 其实如果输入是符合要求的，程序不会执行到这里，为了防止compile error加一下
//            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}