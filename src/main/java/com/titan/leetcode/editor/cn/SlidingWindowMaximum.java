//[239]滑动窗口最大值
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 1032 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
       Solution solution = new SlidingWindowMaximum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // [1,3,1,2,0,5] 3 用例
            if(nums == null || nums.length < 2) return nums;
            Deque<Integer> deque = new ArrayDeque<Integer>();
            int length = nums.length;
            int[] retArray = new int[length - k + 1];

            for (int i = 0; i < length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                    deque.pollLast();
                }
                deque.addLast(i);

                // 将超出k个的值剃除
                if (deque.peekFirst() <= i - k){
                    deque.removeFirst();
                }

                if (i + 1 >= k){
                    retArray[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return retArray;

//            // 就当做k一定小于Nums的长度:不可行，无法确认head的值是否该去除，改用存储下标
//            if(nums == null || nums.length < 2) return nums;
//            Deque<Integer> deque = new ArrayDeque<Integer>();
//
//            int length = nums.length;
//            int[] retArray = new int[length - k + 1];
//
//            for (int i = 0; i < length; i++) {
//                while (!deque.isEmpty() && (deque.peekFirst() < nums[i] || deque.size() >= k)){
//                    deque.pollFirst();
//                }
//                deque.addLast(nums[i]);
//
//                if (i < k - 1){
//                    continue;
//                }
//
//                retArray[i - k + 1] = deque.peekFirst();
//            }
//
//            return retArray;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}