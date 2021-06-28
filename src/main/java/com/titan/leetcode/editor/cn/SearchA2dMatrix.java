//[74]搜索二维矩阵
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 446 👎 0

package com.titan.leetcode.editor.cn;
public class SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();

        System.out.printf(solution.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}}, 11) + "");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }

            // 一次二分，二维有序
            int y = matrix.length;
            int x = matrix[0].length;
            int lo = 0;
            int hi = x * y - 1;
            while (lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if (matrix[mid / x][mid % x] == target) {
                    return true;
                }
                if (matrix[mid / x][mid % x] < target){
                    lo = lo + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return false;

            // 两次二分
//            int y = matrix.length;
//            int x = matrix[0].length;
//
//            //先垂直方向 进行二分查找
//            int ymid = fetchYmid(matrix, target, y);
//
//            //再水平方向 进行二分查找
//            return fetchXmid(matrix, target, ymid, x);
        }

        private boolean fetchXmid(int[][] matrix, int target, int ymid, int x) {
            int left = 0;
            int right = x - 1;
            int xmid = 0;
            while (left <= right){
                xmid = left + (right - left) / 2;
                if (matrix[ymid][xmid] == target){
                    return true;
                }
                if (matrix[ymid][xmid] > target){
                    right = xmid - 1;
                } else {
                    left = xmid + 1;
                }
            }

            return false;
        }

        private int fetchYmid(int[][] matrix, int target, int y) {
            int lo = -1;
            int hi = y - 1;
            int ymid = 0;
            while (lo < hi){
                ymid = lo + (hi - lo + 1) /2;
                if (matrix[ymid][0] <= target){
                    lo = ymid;
                } else {
                    hi = ymid - 1;
                }
            }
            return lo;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}