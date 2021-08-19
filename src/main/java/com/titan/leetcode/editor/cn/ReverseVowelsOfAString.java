//[345]反转字符串中的元音字母
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 191 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString{
    public static void main(String[] args) {
       Solution solution = new ReverseVowelsOfAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            // aeiou
            // 双指针
            return solution1(s);
        }

        private String solution1(String s) {
            char[] chars = s.toCharArray();
            int length = s.length();
            int i = 0, j = length - 1;
            while (i < j){
                while (i < length && !isVowel(chars[i])){
                    i ++;
                }
                while (j > 0 && !isVowel(chars[j])){
                    j --;
                }
                if (i < j){
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    i ++;
                    j --;
                }
            }
            return new String(chars);
        }

        private boolean isVowel(char aChar) {
            return "aeiouAEIOU".indexOf(aChar) > -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}