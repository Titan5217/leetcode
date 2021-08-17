//[526]优美的排列
//假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，
//我们就称这个数组为一个优美的排列。条件： 
//
// 
// 第 i 位的数字能被 i 整除 
// i 能被第 i 位上的数字整除 
// 
//
// 现在给定一个整数 N，请问可以构造多少个优美的排列？ 
//
// 示例1: 
//
// 
//输入: 2
//输出: 2
//解释: 
//
//第 1 个优美的排列是 [1, 2]:
//  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
//
//第 2 个优美的排列是 [2, 1]:
//  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
// 
//
// 说明: 
//
// 
// N 是一个正整数，并且不会超过15。 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 
// 👍 166 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement{
    public static void main(String[] args) {
       Solution solution = new BeautifulArrangement().new Solution();
        solution.countArrangement(2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] matchListArray;
        boolean[] visited;
        int ans = 0;
        public int countArrangement(int n) {
            // 模拟
            return solution1(n);
            // 动态压缩
        }

        private int solution1(int n) {
            // 放位置与数字能整除的数据
            matchListArray = new List[n + 1];
            // 单次记录，已经match的值是否已经被使用
            visited = new boolean[n + 1];

            // 初始化数组值对象
            for (int i = 0; i <= n; i++) {
                matchListArray[i] = new ArrayList<>();
            }

            // i为位置，j为值
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 优美的排列，可放入的字段
                    if (i % j == 0 || j % i == 0){
                        matchListArray[i].add(j);
                    }
                }
            }

            // 递归，从1到n
            recursion(1, n);

            return ans;
        }

        private void recursion(int curr, int n) {
            // 递归终止条件，成功匹配
            if (curr == n + 1){
                ans ++;
                return;
            }
            // DFS遍历从第一个位置开始
            for (int value : matchListArray[curr]) {
                if (!visited[value]){
                    visited[value] = true;
                    // 深度加1
                    recursion(curr + 1, n);
                    visited[value] = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}