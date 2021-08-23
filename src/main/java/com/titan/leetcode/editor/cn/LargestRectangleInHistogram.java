//[84]柱状图中最大的矩形
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1406 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
       Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // 暴力 O(n^2)
            // 单调栈
            return solution1(heights);
        }

        private int solution1(int[] heights) {
            int ans = 0;
            int[] newheight = new int[heights.length + 2];
            for (int i = 1; i < heights.length + 1; i++) {
                newheight[i] = heights[i - 1];
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < newheight.length; i++) {
                while (!stack.isEmpty() && newheight[stack.peek()] > newheight[i]){
                    int curr = stack.pop();
                    int l = stack.peek();
                    int r = i;
                    ans = Math.max (ans, (r - l - 1) * newheight[curr]);
                }
                stack.push(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}