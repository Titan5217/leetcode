//[367]有效的完全平方数
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 226 👎 0

package com.titan.leetcode.editor.cn;
public class ValidPerfectSquare{
  public static void main(String[] args) {
       Solution solution = new ValidPerfectSquare().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        // 二分
        if (num == 1){
            return true;
        }
        int left = 0;
        int right = num;
        int mid = 0;

        while (left <= right){
            mid = left + (right - left) / 2;
            if (mid == num / mid && num % mid == 0){
                return true;
            }

            if (mid > num / mid){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;

//        // 牛顿迭代
//        if (num == 0 || num == 1){
//            return true;
//        }
//        long r = num/2;
//        while (r * r > num){
//            r = (r + num/r) / 2;
//        }
//
//        return (r * r == num);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}