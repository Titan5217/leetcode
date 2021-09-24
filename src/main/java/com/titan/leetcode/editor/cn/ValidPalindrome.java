//[125]验证回文串
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 417 👎 0

package com.titan.leetcode.editor.cn;
public class ValidPalindrome{
    public static void main(String[] args) {
       Solution solution = new ValidPalindrome().new Solution();
        solution.isPalindrome("OP");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            // 反转 equal
            // 双指针
            int left = 0, right = s.length() - 1;
            while (left <= right){
                if (!Character.isLetterOrDigit(s.charAt(left))){
                    left ++;
                } else if (!Character.isLetterOrDigit(s.charAt(right))){
                    right --;
                } else {
                    char char1 = Character.toLowerCase(s.charAt(left++));
                    char char2 = Character.toLowerCase(s.charAt(right--));
                    if (char1 != char2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}