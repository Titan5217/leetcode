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
public class ClimbingStairs{
    public static void main(String[] args) {
       Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
//            f(1) = 1
//            f(2) = 2
//            f(3) = f(2) + f(1)
//            f(n) = f(n - 1) + f(n - 2)
            // 循环
            int f1 = 0;
            int f2 = 0;
            int f3 = 1;

            for (int i = 0; i < n; i++) {
                f1 = f2;
                f2 = f3;
                f3 = f2 + f1;
            }

            return f3;
            // 递归
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}