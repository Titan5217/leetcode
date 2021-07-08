//[70]爬楼梯
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1697 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs{
    public static void main(String[] args) {
       Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public int climbStairs(int n) {
            // 数学？不记得公式，不会推算。。
            // 递归 O(2^n)
//            return recursion(n);
            
            // dp O(n)
            return dp(n);
        }

        private int dp(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        // 带缓存的递归
        private int recursion(int n) {
            if (n <= 2){
                return n;
            }

            if (map.containsKey(n)){
                return map.get(n);
            }

            int value = recursion(n - 1) + recursion(n - 2);

            map.put(n, value);

            return value;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}