//[22]括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1838 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
       new GenerateParentheses().new Solution().generateParenthesis(1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            recursion(0, 0, n, "");
            return list;
        }

        private void recursion(int lCount, int rCount, int maxLevel, String addString) {
            // 结束状态
            if (lCount == maxLevel && rCount == maxLevel){
                list.add(addString);
                return;
            }

            // 当前层级处理

            // 下一层级:左个数小于maxlevel;左个数大于右个数；
            if (lCount < maxLevel){
                recursion(lCount + 1, rCount, maxLevel,addString + "(");
            }
            if (rCount < lCount){
                recursion(lCount, rCount + 1, maxLevel, addString + ")");
            }

            // 组合后加结果
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}