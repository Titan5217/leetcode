//[64]最小路径和
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 925 👎 0

package com.titan.leetcode.editor.cn;
public class MinimumPathSum{
    public static void main(String[] args) {
       Solution solution = new MinimumPathSum().new Solution();
        solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            // 【超时】dfs
            return dfs(grid, grid.length - 1, grid[0].length - 1);

            // dp
//            return dp(grid);
        }

        private int dfs(int[][] grid, int row, int col) {
            if (row == 0 && col == 0){
                return grid[row][col];
            }
            if (row == 0){
                return grid[row][col] + dfs(grid, row, col - 1);
            }
            if (col == 0){
                return grid[row][col] + dfs(grid, row - 1, col);
            }

            return grid[row][col] + Math.min(dfs(grid, row, col - 1), dfs(grid, row - 1, col));
        }

        private int dp(int[][] grid) {
            // DP   dp[i][j]    dp[i][j]=min(dp[i+1][j], dp[i][j+1]) + grid[i][j]
            int row = grid.length;
            int col = grid[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0 && j == 0){
                        continue;
                    }
                    if (i == 0){
                        grid[i][j] = grid[i][j - 1] + grid[i][j];
                        continue;
                    }
                    if (j == 0){
                        grid[i][j] = grid[i - 1][j] + grid[i][j];
                        continue;
                    }
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }

            return grid[row - 1][col - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}