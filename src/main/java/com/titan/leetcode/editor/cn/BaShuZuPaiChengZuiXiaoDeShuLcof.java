//[剑指 Offer 45]把数组排成最小的数
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 
// 👍 277 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
       Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            String[] strArray = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strArray[i] = nums[i] + "";
            }
            Arrays.sort(strArray, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            StringBuffer buffer = new StringBuffer();
            for (String str : strArray) {
                buffer.append(str);
            }
            return buffer.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}