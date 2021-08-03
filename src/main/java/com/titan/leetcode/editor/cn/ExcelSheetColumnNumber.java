//[171]Excel 表列序号
//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
//
// 
//
// 例如， 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 示例 4: 
//
// 
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 
// 👍 262 👎 0

package com.titan.leetcode.editor.cn;
public class ExcelSheetColumnNumber{
    public static void main(String[] args) {
       Solution solution = new ExcelSheetColumnNumber().new Solution();
        solution.titleToNumber("AA");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            int ans = 0;
            for(int i=0;i<columnTitle.length();i++) {
                int num = columnTitle.charAt(i) - 'A' + 1;
                ans = ans * 26 + num;
            }
            return ans;
//            int length = columnTitle.length();
//            int size = 26;
//            int index = 0;
//            int ans = 0;
//            for (int i = length - 1; i >= 0 ; i--) {
//                // 位值 当前位值
//                int value = columnTitle.charAt(i) - 'A' + 1;
//                if (index == 0){
//                    ans += value;
//                } else {
//                    ans += Math.pow(size, index) * value;
//                }
//                index ++;
//            }
//            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}