//[剑指 Offer 50]第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 132 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        solution.firstUniqChar("leetcode");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> tmpMap = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char tmpChar : chars) {
                tmpMap.put(tmpChar, tmpMap.getOrDefault(tmpChar, 0) + 1);
            }
            for (char tmpChar : chars) {
                if (tmpMap.get(tmpChar) == 1) {
                    return tmpChar;
                }
            }
            return ' ';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}