//[43]字符串相乘
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 693 👎 0

package com.titan.leetcode.editor.cn;
public class MultiplyStrings{
    public static void main(String[] args) {
       Solution solution = new MultiplyStrings().new Solution();
        solution.multiply("2","3");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            // 错位相乘
            return solution1(num1, num2);
        }

        private String solution1(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")){
                return "0";
            }
            int length1 = num1.length(), length2 = num2.length();
            int[] array = new int[length1 + length2];
            for (int i = length1 - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = length2 - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    array[i + j + 1] += x * y;
                }
            }
            for (int i = length1 + length2 - 1; i > 0 ; i--) {
                array[i - 1] += array[i] / 10;
                array[i] %= 10;
            }
            int index = array[0] == 0 ? 1 : 0;
            StringBuffer ans = new StringBuffer();
            while (index < length1 + length2) {
                ans.append(array[index]);
                index++;
            }
            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}