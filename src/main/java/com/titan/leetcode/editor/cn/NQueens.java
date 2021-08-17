//[51]N 皇后
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 
// 👍 920 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int queenCount) {
            // 回溯
            // 下标为row,值为所在col
            char[][] tmpArray = new char[queenCount][queenCount];
            for (int i = 0; i < queenCount; i++) {
                for (int j = 0; j < queenCount; j++) {
                    tmpArray[i][j] = '.';
                }
            }
            List<List<String>> retList = new ArrayList<>();
            dfs(queenCount, 0, tmpArray, retList);
            return retList;
        }

//        private void combintList(int[] tmpArray, List<List<String>> retList) {
//            for (int i = 0; i < tmpArray.length; i++) {
//
//            }
//        }

        private void dfs(int queenCount, int col, char[][] tmpArray, List<List<String>> retList) {
            // level 就是
            if (col == queenCount){
                // 如果到这一层级，则说明成功
                retList.add(combineString(tmpArray));
                return;
            }

            for (int i = 0; i < queenCount; i++) {
                if (canPut(tmpArray, col, i)) {
                    tmpArray[i][col] = 'Q';
                    dfs(queenCount, col + 1, tmpArray, retList);
                    tmpArray[i][col] = '.';
                }
            }
        }

        private List<String> combineString(char[][] tmpArray) {
            List<String> tmpList = new ArrayList<>();
            for (int i = 0; i < tmpArray.length; i++) {
                String s = new String(tmpArray[i]);
                tmpList.add(s);
            }
            return tmpList;
        }

        private boolean canPut(char[][] tmpArray, int row, int col) {
//            for (int i = 0; i < tmpArray.length; i++) {
//                if (tmpArray[i] > 0 && (row + tmpArray[i] == col + i || row + col == i + tmpArray[i] || col == tmpArray[i])){
//                    return false;
//                }
//            }
//            return true;
            for(int i = 0; i < tmpArray.length; i++) {
                for(int j = 0; j < row; j++) {
                    if(tmpArray[i][j] == 'Q' && (col + j == row + i || col + row == i + j || col == i))
                        return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}