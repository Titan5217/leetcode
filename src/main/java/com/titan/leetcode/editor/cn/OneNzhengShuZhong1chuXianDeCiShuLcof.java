//[剑指 Offer 43]1～n 整数中 1 出现的次数
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 
// 👍 225 👎 0

package com.titan.leetcode.editor.cn;
public class OneNzhengShuZhong1chuXianDeCiShuLcof{
    public static void main(String[] args) {
       Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
       solution.countDigitOne(55);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int ans = 0;
            for (long mulk = 1; mulk <= n ; mulk *= 10) {
                ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}