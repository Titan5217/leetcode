//[54]螺旋矩阵
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 845 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 模拟
            return solutions1(matrix);
        }

        private List<Integer> solutions1(int[][] matrix) {
            List<Integer> retList = new ArrayList<>();

            int x = matrix.length;
            int y = matrix[0].length;
            if (x == 0 || y == 0){
                return retList;
            }

            int left = 0, top = 0;
            int right = y - 1, bottom = x - 1;
            int matrixNum = x * y;

            while (matrixNum >= 1){
                for (int i = left; i <= right && matrixNum >= 1; i++) {
                    retList.add(matrix[top][i]);
                    matrixNum --;
                }
                top ++;
                for (int i = top; i <= bottom && matrixNum >= 1; i++) {
                    retList.add(matrix[i][right]);
                    matrixNum --;
                }
                right --;
                for (int i = right; i >= left && matrixNum >= 1 ; i--) {
                    retList.add(matrix[bottom][i]);
                    matrixNum --;
                }
                bottom --;
                for (int i = bottom; i >= top && matrixNum >= 1; i--) {
                    retList.add(matrix[i][left]);
                    matrixNum --;
                }
                left ++;
            }
            return retList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}