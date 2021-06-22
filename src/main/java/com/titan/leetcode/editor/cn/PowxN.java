//[50]Pow(x, n)
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 669 👎 0

package com.titan.leetcode.editor.cn;
public class PowxN{
    public static void main(String[] args) {
       Solution solution = new PowxN().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            // 较强代码
            if(n == Integer.MIN_VALUE){
                return (x == 1 || x == -1) ? 1 : 0;
            }
            if (n == 0)
                return 1;
            if (n < 0){
                n = -n;
                x = 1/x;
            }

            double value = myPow(x, n / 2);

            return (n % 2 == 0) ? value * value : x * value * value;

            // 递归，分治
//            if (n < 0){
//                n = Math.abs(n);
//                x = 1/x;
//            }
//
//            return recursionMyPow(x, n);

            // [超时]暴力，迭代，乘积
//            double returnValue = 1d;
//
//            if (n < 0){
//                n = Math.abs(n);
//                x = 1/x;
//            }
//            for (int i = 0; i < n; i++) {
//                returnValue = returnValue * x;
//            }
//            return returnValue;
        }

//        private double recursionMyPow(double x, int n) {
//            if (n == 0){
//                return 1;
//            }
//
//            double value = recursionMyPow(x, n / 2);
//            return n % 2 == 1 ? value * value * x : value * value;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}