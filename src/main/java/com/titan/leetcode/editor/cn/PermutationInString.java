//[567]字符串的排列
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 443 👎 0

package com.titan.leetcode.editor.cn;
public class PermutationInString{
    public static void main(String[] args) {
       Solution solution = new PermutationInString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (m < n){
                return false;
            }
            int[] count = new int[26];
            for (int i = 0; i < n; i++) {
                --count[s1.charAt(i) - 'a'];
                ++count[s2.charAt(i) - 'a'];
            }
            int diff = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0){
                    diff ++;
                }
            }
            if (diff == 0){
                return true;
            }
            for (int i = n; i < m; i++) {
                int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
                if (x == y) {
                    continue;
                }
                if (count[x] == 0) {
                    ++diff;
                }
                ++count[x];
                if (count[x] == 0) {
                    --diff;
                }
                if (count[y] == 0) {
                    ++diff;
                }
                --count[y];
                if (count[y] == 0) {
                    --diff;
                }
                if (diff == 0) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}