//[剑指 Offer 10- II]青蛙跳台阶问题
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 191 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int MOD = 1000000007;
        public int numWays(int n) {
            if (n <= 1){
                return 1;
            }

            Map<Integer, Integer> tmpMap = new HashMap<>();
            tmpMap.put(0, 1);
            tmpMap.put(1, 1);
            int ans = -1;
            for (int i = 2; i <= n; i++) {
                ans = (tmpMap.getOrDefault(i - 1, 0) + tmpMap.getOrDefault(i - 2, 0)) % MOD;
                tmpMap.put(i, ans);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}