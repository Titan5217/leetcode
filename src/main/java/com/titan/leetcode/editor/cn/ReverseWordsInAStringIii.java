//[557]反转字符串中的单词 III
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 308 👎 0

package com.titan.leetcode.editor.cn;
public class ReverseWordsInAStringIii{
    public static void main(String[] args) {
       Solution solution = new ReverseWordsInAStringIii().new Solution();
       solution.reverseWords("Let's take LeetCode contest");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0){
                return s;
            }

            StringBuffer buffer = new StringBuffer();

            int length = s.length();
            int i = 0, j = 0;
            while (j < length){
                while (i < length && s.charAt(i) == ' '){
                    buffer.append(" ");
                    i ++;
                }

                j = i;
                while (j < length && s.charAt(j) != ' '){
                    j ++;
                }

                buffer.append(reverse(s, i, j));
                i = j;
            }

            return buffer.toString();
        }

        private String reverse(String s, int i, int j) {
            char[] chars = s.substring(i, j).toCharArray();

            for (int x = 0, y = chars.length - 1; x < y; x++, y --) {
                char tmp = chars[x];
                chars[x] = chars[y];
                chars[y] = tmp;
            }

            return new String(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}