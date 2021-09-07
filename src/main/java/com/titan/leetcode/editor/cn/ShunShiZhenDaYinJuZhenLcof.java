//[剑指 Offer 29]顺时针打印矩阵
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 292 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
       Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
       solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int x = matrix.length;
            if (x == 0){
                return new int[]{};
            }
            int y = matrix[0].length;
            if (y == 0){
                return new int[]{};
            }

            int left = 0, top = 0;
            int right = y - 1, bottom = x - 1;
            int totalCount = x * y;
            int currentCount = 0;
            int[] retArray = new int[totalCount];
            while (currentCount <  totalCount){
                for (int i = left; i <= right & currentCount < totalCount; i++) {
                    retArray[currentCount] = matrix[top][i];
                    currentCount ++;
                }
                top ++;
                for (int i = top; i <= bottom && currentCount <  totalCount; i++) {
                    retArray[currentCount] = matrix[i][right];
                    currentCount ++;
                }
                right --;
                for (int i = right; i >= left && currentCount <  totalCount ; i--) {
                    retArray[currentCount] = matrix[bottom][i];
                    currentCount ++;
                }
                bottom --;
                for (int i = bottom; i >= top && currentCount <  totalCount; i--) {
                    retArray[currentCount] = matrix[i][left];
                    currentCount ++;
                }
                left ++;
            }

            return retArray;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}