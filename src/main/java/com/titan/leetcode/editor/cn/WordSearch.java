//[79]单词搜索
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 996 👎 0

package com.titan.leetcode.editor.cn;
public class WordSearch{
    public static void main(String[] args) {
       Solution solution = new WordSearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        private int rows;
        private int cols;
        private int len;
        private boolean[][] visited;
        private char[] charArray;
        private char[][] board;
        public boolean exist(char[][] board, String word) {
            rows = board.length;
            cols = board[0].length;
            len = word.length();
            visited = new boolean[rows][cols];
            this.board = board;
            this.charArray = word.toCharArray();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(i, j, 0)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (start == len - 1){
                return board[i][j] == charArray[start];
            }
            if (board[i][j] == charArray[start]){
                visited[i][j] = true;
                for (int[] direct: DIRECTIONS) {
                    int tx = i + direct[0];
                    int ty = j + direct[1];
                    if (inArea(tx, ty) && !visited[tx][ty]){
                        if (inArea(tx, ty) && dfs(tx, ty, start + 1)){
                            return true;
                        }
                    }
                }
                visited[i][j] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}