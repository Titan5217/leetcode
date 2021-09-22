//[剑指 Offer 59 - I]滑动窗口的最大值
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 
// 👍 318 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
       Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 2){
                return nums;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            int length = nums.length;
            int[] retArray = new int[length - k + 1];
            for (int i = 0; i < length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                    deque.pollLast();
                }
                deque.addLast(i);
                if (deque.peekFirst() <= i - k){
                    deque.removeFirst();
                }
                if (i + 1 >= k){
                    retArray[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return retArray;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}