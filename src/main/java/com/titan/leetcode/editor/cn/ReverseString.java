//[344]反转字符串
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 递归 双指针 字符串 
// 👍 426 👎 0

package com.titan.leetcode.editor.cn;
public class ReverseString{
    public static void main(String[] args) {
       Solution solution = new ReverseString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            // 双指针
            if (s == null || s.length == 0){
                return;
            }
            int length = s.length;
            for (int i = 0, j  = length - 1; i < j; ++i, --j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }

//            if (s == null || s.length == 0){
//                return;
//            }
//            int length = s.length;
//
//            for (int i = 0; i < (length + 1) /2; i++) {
//                char tmp = s[i];
//                s[i] = s[length - 1 - i];
//                s[length - 1 - i] = tmp;
//            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}