//[44]通配符匹配
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 
// 👍 725 👎 0

package com.titan.leetcode.editor.cn;
public class WildcardMatching{
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            // dp
            return dp(s, p);
        }

        private boolean dp(String s, String p) {
            int sLength = s.length();
            int pLength = p.length();
            boolean[][] mom = new boolean[sLength + 1][pLength + 1];
            mom[0][0] = true;
            for (int i = 0; i < pLength; i++) {
                if (p.charAt(i) == '*'){
                    mom[0][i + 1] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= sLength; i++) {
                for (int j = 1; j <= pLength; j++) {
                    if (p.charAt(j - 1) == '*'){
                        mom[i][j] = mom[i][j - 1] || mom[i - 1][j];
                    } else if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        mom[i][j] = mom[i - 1][j - 1];
                    }
                }
            }

            return mom[sLength][pLength];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}