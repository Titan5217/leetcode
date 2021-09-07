//[剑指 Offer 12]矩阵中的路径
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 395 👎 0

package com.titan.leetcode.editor.cn;
public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
       Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        solution.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "abcd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        public boolean exist(char[][] board, String word) {
            int bx = board.length;
            int by = board[0].length;
            char[] words = word.toCharArray();
            for (int i = 0; i < bx; i++) {
                for (int j = 0; j < by; j++) {
                    if (board[i][j] != words[0]){
                        continue;
                    }
                    if (dfs(board, words, i, j, 0)){
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, char[] words, int x, int y, int currentWordLength) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != words[currentWordLength]){
                return false;
            }
            if (currentWordLength == words.length - 1){
                return true;
            }
            board[x][y] = '\0';
            // 执行效率竟然比下边的方式效率低
//            boolean res = false;
//            for (int i = 0; i < 4; i++) {
//                res |= dfs(board, words, x + dx[i], y + dy[i], currentWordLength + 1);
//            }
            boolean res = dfs(board, words, x + 1, y, currentWordLength + 1) || dfs(board, words, x - 1, y, currentWordLength + 1) ||
                    dfs(board, words, x, y + 1, currentWordLength + 1) || dfs(board, words, x , y - 1, currentWordLength + 1);
            board[x][y] = words[currentWordLength];
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}