//[面试题 17.14]最小K个数
//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 100 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestKLcci{
    public static void main(String[] args) {
       Solution solution = new SmallestKLcci().new Solution();
       solution.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            // 排序，取前k
            return solution2(arr, k);
            // 大顶堆
//            return solution1(arr, k);
        }

        private int[] solution2(int[] arr, int k) {
            int[] retArray = new int[k];
            Arrays.sort(arr);
            System.arraycopy(arr, 0, retArray, 0, k);
            return retArray;
        }

//        private int[] solution1(int[] arr, int k) {
//            int[] retArray = new int[k];
//            if (k == 0){
//                return retArray;
//            }
//            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//            for (int i = 0; i < k && i < arr.length; i++) {
//                queue.offer(arr[i]);
//            }
//
//            for (int i = k; i < arr.length; i++) {
//                if (queue.peek() > arr[i]){
//                    queue.poll();
//                    queue.offer(arr[i]);
//                }
//            }
//
//            int queueSize = queue.size();
//            for (int i = 0; i < queueSize; i++) {
//                retArray[i] = queue.poll();
//            }
//            return retArray;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}