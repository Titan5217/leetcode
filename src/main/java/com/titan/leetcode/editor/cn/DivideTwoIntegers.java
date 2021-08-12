//[29]两数相除
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 
// 👍 630 👎 0

package com.titan.leetcode.editor.cn;
public class DivideTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            // 二分
            return solution1(dividend, divisor);
        }

        private int solution1(int dividend, int divisor) {
            // 如果除数为非0的正整数，那么结果应该在0~被除数间
            long x = dividend, y = divisor;
            boolean isNeg = (x > 0 && y < 0) || (x < 0 && y > 0) ? true : false;
            x = Math.abs(x);
            y = Math.abs(y);
            long left = 0, right = x;
            while (left < right){
                long mid = left + right + 1 >> 1;
                if (mul(mid, y) <= x){
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            long ans = isNeg ? -left : left;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return (int)ans;
        }

        private long mul(long x, long y) {
            long ans = 0;
            while (y > 0) {
                if ((y & 1) == 1){
                    ans += x;
                }
                y = y >> 1;
                x += x;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}