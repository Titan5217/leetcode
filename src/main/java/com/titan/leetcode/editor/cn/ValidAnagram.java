//[242]有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 394 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram{
    public static void main(String[] args) {
       Solution solution = new ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            // 暴力法, 扫每个字母个数，对比
            // 按字母排序后，对比两个值是否相等
//            if (s.length() != t.length()){
//                return false;
//            }
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            Arrays.sort(sChars);
//            Arrays.sort(tChars);
//            return Arrays.equals(sChars, tChars);

            // 哈希表？
//            if (s.length() != t.length()) {
//                return false;
//            }
//            int[] tmpArray = new int[26];
//            for (int i = 0; i < s.length(); i++) {
//                tmpArray[s.charAt(i) - 'a']++;
//            }
//            for (int i = 0; i < t.length(); i++) {
//                tmpArray[t.charAt(i) - 'a']--;
//                if (tmpArray[t.charAt(i) - 'a'] < 0) {
//                    return false;
//                }
//            }
//            return true;

            // A字符串中的字符，遇到则往map中加1，B字符串中的字符，遇到则往map中减1。最后对比map中所有的值是否都为空
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> tmpMap = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                tmpMap.put(s.charAt(i), tmpMap.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < t.length(); i++) {
                tmpMap.put(t.charAt(i), tmpMap.getOrDefault(t.charAt(i), 0) - 1);
                if (tmpMap.get(t.charAt(i)) < 0){
                    return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}