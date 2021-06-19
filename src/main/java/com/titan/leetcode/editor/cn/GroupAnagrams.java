//[49]字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 763 👎 0

package com.titan.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            // 1.将字符串排序当作key
            Map<String, List<String>> tmpMap = new HashMap<>();
            for (String str : strs) {
                String sortedStr = getSortedStr(str);
                List<String> tmpList = tmpMap.getOrDefault(sortedStr, new ArrayList<>());
                tmpList.add(str);
                tmpMap.put(sortedStr, tmpList);
            }

            return new ArrayList<>(tmpMap.values());
        }

        private String getSortedStr(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}