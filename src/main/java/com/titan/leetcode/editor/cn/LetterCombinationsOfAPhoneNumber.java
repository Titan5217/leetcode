//[17]电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1366 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            // 回溯
            List<String> combinations = new ArrayList<String>();
            if (digits == null || digits.length() == 0){
                return combinations;
            }
            Map<Character, String> tmpMap = new HashMap<>();
            tmpMap.put('2', "abc");
            tmpMap.put('3', "def");
            tmpMap.put('4', "ghi");
            tmpMap.put('5', "jkl");
            tmpMap.put('6', "mno");
            tmpMap.put('7', "pqrs");
            tmpMap.put('8', "tuv");
            tmpMap.put('9', "wxyz");
            
            letterCombination(combinations, tmpMap, digits, 0, new StringBuffer());
            return combinations;
        }

        private void letterCombination(List<String> combinations, Map<Character, String> tmpMap, String digits, int index, StringBuffer stringBuffer) {
            if (index == digits.length()){
                combinations.add(stringBuffer.toString());
            } else {
                String letters = tmpMap.get(digits.charAt(index));
                for (int i = 0; i < letters.length(); i++) {
                    stringBuffer.append(letters.charAt(i));
                    letterCombination(combinations, tmpMap, digits, index + 1, stringBuffer);
                    stringBuffer.deleteCharAt(index);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}