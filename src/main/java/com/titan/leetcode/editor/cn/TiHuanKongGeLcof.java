//[剑指 Offer 05]替换空格
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 
// 👍 153 👎 0

package com.titan.leetcode.editor.cn;
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
       Solution solution = new TiHuanKongGeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            if (null == s){
                return s;
            }

            StringBuilder builder = new StringBuilder();

            int length = s.length();
            char tmpChar;
            for(int i = 0; i < length; i ++){
                tmpChar = s.charAt(i);
                if (tmpChar == ' '){
                    builder.append("%20");
                } else {
                    builder.append(tmpChar);
                }
            }

            return builder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}