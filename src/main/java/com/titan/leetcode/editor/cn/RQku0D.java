//[剑指 Offer II 019]最多删除一个字符得到回文
//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 105 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 
// 👍 4 👎 0

package com.titan.leetcode.editor.cn;
public class RQku0D{
    public static void main(String[] args) {
       Solution solution = new RQku0D().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int low = 0, high = s.length() - 1;
            while (low < high) {
                char c1 = s.charAt(low), c2 = s.charAt(high);
                if (c1 == c2) {
                    ++low;
                    --high;
                } else {
                    return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
                }
            }
            return true;
        }

        public boolean validPalindrome(String s, int low, int high) {
            for (int i = low, j = high; i < j; ++i, --j) {
                char c1 = s.charAt(i), c2 = s.charAt(j);
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}