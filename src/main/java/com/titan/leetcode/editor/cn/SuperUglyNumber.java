//[313]超级丑数
//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。 
//
// 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。 
//
// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12, primes = [2,7,13,19]
//输出：32 
//解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
//28,32] 。 
//
// 示例 2： 
//
// 
//输入：n = 1, primes = [2,3,5]
//输出：1
//解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
// 
// 
//
// 
// 
// 
// 提示： 
//
// 
// 1 <= n <= 106 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// 题目数据 保证 primes[i] 是一个质数 
// primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
// 
// 
// 
// 
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 
// 👍 192 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber{
    public static void main(String[] args) {
       Solution solution = new SuperUglyNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            // 最小堆
//            return solution1(n, primes);
            // dp
            return solution2(n, primes);
        }

        private int solution2(int n, int[] primes) {
            int[] mom = new int[n + 1];
            mom[1] = 1;
            int length = primes.length;
            int[] useCount = new int[length];
            Arrays.fill(useCount, 1);
            for (int i = 2; i <= n ; i++) {
                int minValue = Integer.MAX_VALUE;
                int[] nums = new int[length];
                for (int j = 0; j < length; j++) {
                    nums[j] = mom[useCount[j]] * primes[j];
                    minValue = Math.min(nums[j], minValue);
                }
                mom[i] = minValue;
                for (int j = 0; j < length; j++) {
                    if (minValue == nums[j]){
                        useCount[j] ++;
                    }
                }
            }
            return mom[n];
        }

        private int solution1(int n, int[] primes) {
            PriorityQueue<Long> heap = new PriorityQueue<>();
            heap.offer(1L);
            Set<Long> visited = new HashSet<>();
            visited.add(1L);
            int ugly = 1;
            for (int i = 0; i < n; i++) {
                long curr = heap.poll();
                ugly = (int)curr;
                for (int prime: primes) {
                    long value = curr * prime;
                    if (visited.add(value)){
                        heap.offer(value);
                    }
                }
            }
            return ugly;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}