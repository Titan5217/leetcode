//[524]通过删除字母匹配到字典里最长单词
//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 
// 👍 185 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting{
    public static void main(String[] args) {
       Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        solution.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            // 字典序最小，竟然不是第一个在dictionary中出现。。。
            String ans = "";
            int maxLength = 0;
            for (String word : dictionary) {
                int length = compare(word, s);
                if (length > maxLength){
                    maxLength = length;
                    ans = word;
                } else if (length == maxLength){
                    ans = word.compareTo(ans) > 0 ? ans : word;
                }
            }
            return ans;
        }

        private int compare(String word, String s) {
            if (s.equals(word)){
                return s.length();
            }
            if (s.length() < word.length()){
                return -1;
            }
            int i = 0;
            int j = 0;
            while (i < s.length() && j < word.length()){
                if (s.charAt(i) == word.charAt(j)){
                    j ++;
                }
                i ++;
                if (j == word.length()){
                    return j;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}