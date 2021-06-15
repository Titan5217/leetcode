//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2534 👎 0

package com.titan.leetcode.editor.cn;
public class ContainerWithMostWater{
  public static void main(String[] args) {
       Solution solution = new ContainerWithMostWater().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      //solution1: 暴力法，双重循环，穷举
      //solution2: 双向收缩，缩小的一面
      public int maxArea(int[] height) {
        int maxSize = 0;

        for (int i = 0, j = height.length - 1; i < j;){
            int minHeight = height[i] > height[j] ? height[j--] : height[i ++];
            maxSize = Math.max(maxSize, getArea(minHeight, j - i + 1));
        }
        return maxSize;
      }

      //solution3: 【繁琐，未成功】双向收缩，缩小的一面,每次收缩的值要小于当前值；
//      public int maxArea(int[] height) {
//          int arraySize = height.length;
//
//          int maxSize = getArea(Math.min(height[0], height[arraySize - 1]), arraySize);
//
//          for (int i = 0, j = height.length - 1; i < j;){
//              if (height[i] > height[j]) {
//                  int tmp  = height[j];
//                  int aj = j;
//                  while (i < j){
//                      if (height[--aj] < tmp){
//                          j = aj;
//                          break;
//                      }
//                  }
//
//              } else {
//                  int tmp  = height[i];
//                  int ai = i;
//                  while (i < j){
//                      if (tmp < height[++ai]){
//                          i = ai;
//                          break;
//                      }
//                  }
//              }
//
//              int minHeight = Math.min(height[i], height[j]);
//              maxSize = Math.max(maxSize, getArea(minHeight, j - i));
//          }
//          return maxSize;
//      }

      private int getArea(int heitght, int width) {
        return width * heitght;
      }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}