//[55]跳跃游戏
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1287 👎 0

package com.titan.leetcode.editor.cn;
public class JumpGame{
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        solution.canJump(new int[]{0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            // 贪心
//            return greed(nums);
            // dp
            return dynamicPlanning(nums);
        }

        private boolean dynamicPlanning(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return true;
            } else if (nums[0] == 0) {
                return false;
            }

            boolean[] mom = new boolean[length];
            mom[0] = true;
            mom[1] = true;

            int maxIndex = 0;
            for (int i = 0; i < length - 1; i++) {
                if (!mom[i]){
                    continue;
                }
                int tmpIndex = i + nums[i];
                for (int j = maxIndex; j <= tmpIndex; j++) {
                    if (j < length && !mom[j]){
                        mom[j] = true;
                    }
                }
                maxIndex = tmpIndex;
            }
            return mom[length - 1];
        }

        private boolean greed(int[] nums) {
            int length = nums.length;
            int farest = 0;
            for (int i = 0; i < length; i++) {
                if (i > farest){
                    return false;
                }
                farest = Math.max(farest, i + nums[i]);
                if (farest >= length - 1){
                    return true;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}