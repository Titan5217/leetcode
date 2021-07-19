//[387]字符串中的第一个唯一字符
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 417 👎 0

package com.titan.leetcode.editor.cn;
public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
       Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int length = s.length();
            int[] array = new int[26];
            for (int i = 0; i < length; i++) {
                int tmpValue = s.charAt(i) - 'a';
                array[tmpValue] += 1;
            }
            for (int i = 0; i < length; i++) {
                if (array[s.charAt(i) - 'a'] == 1){
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}