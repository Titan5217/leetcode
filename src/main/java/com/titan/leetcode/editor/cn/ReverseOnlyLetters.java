//[917]仅仅反转字母
//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 双指针 字符串 
// 👍 81 👎 0

package com.titan.leetcode.editor.cn;
public class ReverseOnlyLetters{
    public static void main(String[] args) {
       Solution solution = new ReverseOnlyLetters().new Solution();
       solution.reverseOnlyLetters("Test1ng-Leet=code-Q!");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            if (s == null || s.length() == 0){
                return s;
            }

            char[] chars = s.toCharArray();
            int i = 0;
            int j = s.length() - 1;
            while (i < j){
                while (i < j && !(chars[i] >= 'A' && chars[i] <= 'Z') && !(chars[i] >= 'a' && chars[i] <= 'z')){
                    i ++;
                }

                while (i < j && !(chars[j] >= 'A' && chars[j] <= 'Z') && !(chars[j] >= 'a' && chars[j] <= 'z')){
                    j --;
                }

                if (i >= j){
                    break;
                }

                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;

                i ++;
                j --;
            }

            return new String(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}