//[120]三角形最小路径和
//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 788 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Triangle{
    public static void main(String[] args) {
       Solution solution = new Triangle().new Solution();
//       solution.minimumTotal(Arrays.asList(new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            // [超时]递归,可加缓存进行记忆
//            return dfs(triangle, 0, 0);
            // DP，影响传入数组
//            return dp(triangle);
            // DP，不影响传入数组
            return dp2(triangle);
        }

        private int dp2(List<List<Integer>> triangle) {
            int[] tmpArray = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    tmpArray[j] = Math.min(tmpArray[j], tmpArray[j + 1]) + triangle.get(i).get(j);
                }
            }
            return tmpArray[0];
        }

        /**
         * 影响传入参数中的值
         * @param triangle
         * @return
         */
        private int dp(List<List<Integer>> triangle) {
//            x[i][j] = min(x[i + 1][j], x[i + 1][j + 1]) + x[i][j];
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = triangle.get(i).size() - 1; j >= 0 ; j--) {
                    triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
                }
            }
            return triangle.get(0).get(0);
        }

        private int dfs(List<List<Integer>> triangle, int i, int j) {
            if (i == triangle.size()){
                return 0;
            }

            return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}