//[295]数据流的中位数
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 485 👎 0

package com.titan.leetcode.editor.cn;

import java.util.PriorityQueue;

public class FindMedianFromDataStream{
//  public static void main(String[] args) {
//       Solution solution = new FindMedianFromDataStream().new Solution();
//  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        // 大小顶堆
        private PriorityQueue<Integer> smallQueue;
        private PriorityQueue<Integer> bigQueue;
        public MedianFinder() {
            smallQueue = new PriorityQueue<Integer>((a, b) -> (b - a));
            bigQueue = new PriorityQueue<Integer>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (smallQueue.isEmpty() || num <= smallQueue.peek()){
                smallQueue.offer(num);
                if (bigQueue.size() + 1 < smallQueue.size()){
                    bigQueue.offer(smallQueue.poll());
                }
            } else {
                bigQueue.offer(num);
                if (bigQueue.size() > smallQueue.size()){
                    smallQueue.offer(bigQueue.poll());
                }
            }
        }

        public double findMedian() {
            if (smallQueue.size() > bigQueue.size()){
                return smallQueue.peek();
            }
            return (smallQueue.peek() + bigQueue.peek()) / 2.0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}