//[818]赛车
//你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。） 
//
// 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。 
//
// 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。 
//
// 当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。 (当前所
//处位置不变。) 
//
// 例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。 
//
// 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。 
//
// 
//
// 
//示例 1:
//输入: 
//target = 3
//输出: 2
//解释: 
//最短指令列表为 "AA"
//位置变化为 0->1->3
// 
//
// 
//示例 2:
//输入: 
//target = 6
//输出: 5
//解释: 
//最短指令列表为 "AAARA"
//位置变化为 0->1->3->7->7->6
// 
//
// 说明: 
//
// 
// 1 <= target（目标位置） <= 10000。 
// 
// Related Topics 动态规划 
// 👍 106 👎 0

package com.titan.leetcode.editor.cn;
public class RaceCar{
    public static void main(String[] args) {
       Solution solution = new RaceCar().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int racecar(int target) {
            // DP
            return dp(target);
        }

        private int dp(int target) {
            // 到达第i位用的最少步数
            int[] dp = new int[target + 1];
            for (int i = 1; i <= target; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; (1 << j) - 1 < i * 2; j++) {
                    int speed = (1 << j) - 1;
                    if (i == speed){ //刚刚好
                        dp[i] = j;
                    } else if(speed > i){ // 过了，需要往回走
                        dp[i] = Math.min(dp[i], j + 1 + dp[speed - i]);
                    } else {
                        for(int back = 0; back < j; back++) { //未到，需要补步
                            int k = (1 << back) - 1;
                            dp[i] =Math.min(dp[i], j + 1 + back + 1 + dp[i - speed + k]);
                        }
                    }
                }
            }

            return dp[target];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}