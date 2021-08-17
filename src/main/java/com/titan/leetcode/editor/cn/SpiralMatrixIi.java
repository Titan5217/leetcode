//[59]螺旋矩阵 II
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 462 👎 0

package com.titan.leetcode.editor.cn;
public class SpiralMatrixIi{
    public static void main(String[] args) {
       Solution solution = new SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            // 迭代
            return solution1(n);
        }

        private int[][] solution1(int n) {
            int[][] matrix = new int[n][n];

            int totalCount = n * n;
            int current = 1;
            int left = 0, top = 0;
            int right = n - 1, bottom = n - 1;
            while (current <= totalCount){
                for (int i = left; i <= right && current <= totalCount; i++) {
                    matrix[top][i] = current++;
                }
                top ++;
                for (int i = top; i <= bottom && current <= totalCount ; i++) {
                    matrix[i][right] = current++;
                }
                right --;
                for (int i = right; i >= left && current <= totalCount ; i--) {
                    matrix[bottom][i] = current++;
                }
                bottom --;
                for (int i = bottom; i >= top && current <= totalCount ; i--) {
                    matrix[i][left] = current++;
                }
                left ++;
            }

            return matrix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}