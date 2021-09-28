//[371]两整数之和
//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics 位运算 数学 
// 👍 466 👎 0

package com.titan.leetcode.editor.cn;
public class SumOfTwoIntegers{
    public static void main(String[] args) {
       Solution solution = new SumOfTwoIntegers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
//            return solution1(a, b);
            return solution2(a, b);
        }

        private int solution2(int a, int b) {
            return b == 0 ? a : solution2(a ^ b, (a & b) << 1);
        }

//        private int solution1(int a, int b) {
//            int ans = 0;
//            for (int i = 0, t = 0; i < 32; i++) {
//                int u1 = (a >> i) & 1, u2 = (b >> i) & 1;
//                if (u1 == 1 && u2 == 1) {
//                    ans |= (t << i);
//                    t = 1;
//                } else if (u1 == 1 || u2 == 1) {
//                    ans |= ((1 ^ t) << i);
//                } else {
//                    ans |= (t << i);
//                    t = 0;
//                }
//            }
//            return ans;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}