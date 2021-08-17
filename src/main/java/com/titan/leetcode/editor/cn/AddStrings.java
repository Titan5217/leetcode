//[415]字符串相加
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 423 👎 0

package com.titan.leetcode.editor.cn;
public class AddStrings{
    public static void main(String[] args) {
       Solution solution = new AddStrings().new Solution();
        solution.addStrings("1", "999");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            if (num1 == "0" || num2 == "0"){
                return num1 == "0" ? num2 : num1;
            }
            int length1 = num1.length(), length2 = num2.length();
            int length = Math.max(length1, length2);
            int[] tmpArray = new int[length + 1];
            for (int i = length; i > 0; i --) {
                int x = (i - length + length1 - 1 < 0) ? 0 : num1.charAt(i - length + length1 - 1) - '0';
                int y = (i - length + length2 - 1 < 0) ? 0 : num2.charAt(i - length + length2 - 1) - '0';
                tmpArray[i] += x + y;
            }

            for (int i = length; i >= 1; i--) {
                tmpArray[i - 1] += tmpArray[i] / 10;
                tmpArray[i] = tmpArray[i] % 10;
            }

            int index = tmpArray[0] == 0 ? 1 : 0;
            StringBuffer buffer = new StringBuffer();
            while (index <= length){
                buffer.append(tmpArray[index ++]);
            }
            return buffer.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}