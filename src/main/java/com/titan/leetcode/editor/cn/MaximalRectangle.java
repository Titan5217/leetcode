//[85]最大矩形
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 976 👎 0

package com.titan.leetcode.editor.cn;
public class MaximalRectangle{
     public static void main(String[] args) {
       Solution solution = new MaximalRectangle().new Solution();
       solution.maximalRectangle(new char[][]{{'1','0','1','1','1'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            // dp
            int x = matrix.length;
            if (x == 0){
                return 0;
            }
            int y = matrix[0].length;
            //多加一列，减少一些判断等处理
            int[][] dp = new int[x + 1][y + 1];
            // 根据matrix初始化dp表
            for (int i = 1; i <= x; i++) {
                for (int j = 1; j <= y; j++) {
                    if (matrix[i - 1][j - 1] == '1'){
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= x; i++) {
                for (int j = 1; j <= y; j++) {
                    if (dp[i][j] != 0){
                        int width = 1;
                        // 左右取大于此值的个数
                        int tmpj = j;
                        while (tmpj - 1 >= 0 && dp[i][j] <= dp[i][tmpj - 1]){
                            width ++;
                            tmpj --;
                        }
                        tmpj = j;
                        while (tmpj + 1 <= y && dp[i][j] <= dp[i][tmpj + 1]){
                            width ++;
                            tmpj ++;
                        }
                        ans = Math.max(ans, width * dp[i][j]);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}