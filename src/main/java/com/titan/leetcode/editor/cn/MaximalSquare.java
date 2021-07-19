//[221]最大正方形
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 806 👎 0

package com.titan.leetcode.editor.cn;
public class MaximalSquare{
    public static void main(String[] args) {
       Solution solution = new MaximalSquare().new Solution();
        solution.maximalSquare(new char[][]{{'0','1'},{'1','0'}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            return dp(matrix);
        }

        private int dp(char[][] matrix) {
            int area = 0;

            int row = matrix.length;
            int col = matrix[0].length;

            int[][] dp = new int[row][col];
            // 初始化第一层
            for (int i = 0; i < row; i++) {
                dp[i][0] = matrix[i][0] - '0';
                if (dp[i][0] > 0){
                    area = 1;
                }
            }
            for (int i = 0; i < col; i++) {
                dp[0][i] = matrix[0][i] - '0';
                if (dp[0][i] > 0){
                    area = 1;
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] - '0' == 0){
                        dp[i][j] = 0;
                        continue;
                    }

                    int v1 = dp[i - 1][j - 1];
                    int v2 = dp[i - 1][j];
                    int v3 = dp[i][j - 1];

                    if (v1 == v2 && v2 == v3){
                        dp[i][j] = v1 + 1;
                        area = Math.max(area, dp[i][j] * dp[i][j]);
                    } else {
                        dp[i][j] = Math.min(v1, Math.min(v2, v3)) + 1;
                    }
                }
            }

            return area;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}