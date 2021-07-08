//[52]N皇后 II
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯 
// 👍 275 👎 0

package com.titan.leetcode.editor.cn;
public class NQueensIi{
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        solution.totalNQueens(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            // 初始化化一个二维数组，用来存储中间过程状态, 下标为行，值为列，如果值为-1，则说明没存值
            int[] tmpArray = new int[n];
            for (int i = 0; i < n; i++) {
                tmpArray[i] = -1;
            }
            // dfs 回溯
            return dfs(n, 0, tmpArray, 0);
        }

        private int dfs(int queenCount, int currentLevel, int[] tmpArray, int retCount) {
            if (queenCount == currentLevel){
                return retCount + 1;
            }

            for (int i = 0; i < queenCount; i++) {
                if (isValid(currentLevel, i, tmpArray)){
                    tmpArray[currentLevel] = i;
                    retCount = dfs(queenCount, currentLevel + 1, tmpArray, retCount);
                    tmpArray[currentLevel] = -1;
                }
            }
            return retCount;
        }

        private boolean isValid(int row, int col, int[] tmpArray) {
            for (int i = 0; i < tmpArray.length; i++) {
                if (tmpArray[i] < 0){
                    continue;
                }
                int x = i;
                int y = tmpArray[i];
                if (x + y == row + col || x - y == row - col || x == row || y == col){
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}