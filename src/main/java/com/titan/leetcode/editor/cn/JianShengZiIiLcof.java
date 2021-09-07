//[剑指 Offer 14- II]剪绳子 II
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 132 👎 0

package com.titan.leetcode.editor.cn;
public class JianShengZiIiLcof{
    public static void main(String[] args) {
       Solution solution = new JianShengZiIiLcof().new Solution();
  }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = 1000000007;
        public int cuttingRope(int n) {
//            // 贪心算法
//            if ( n < 4){
//                return n-1;
//            }
//            int res = 1;
//
//            while (n > 4){
//                n = n - 3;
//                res = res % MOD;
//                res *= 3;
//            }
//            if (n < 4) {
//                res *= n;
//            }
//            if (n == 4){
//                res *= 4;
//            }
//            return (int)(res%MOD);
            //贪心算法
            if(n<4) return n-1;

            long res=1;
            while(n>4){
                n=n-3;
                res=res%MOD;
                res*=3;

            }
            if(n<4) res*=n;
            if(n==4) res*=4;
            return (int)(res%MOD);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}