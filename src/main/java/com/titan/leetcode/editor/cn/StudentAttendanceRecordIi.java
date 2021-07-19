//[552]学生出勤记录 II
//给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。 
//
// 学生出勤记录是只包含以下三个字符的字符串： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 8 
//解释：
//有8个长度为2的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
//只有"AA"不会被视为可奖励，因为缺勤次数超过一次。 
//
// 注意：n 的值不会超过100000。 
// Related Topics 动态规划 
// 👍 142 👎 0

package com.titan.leetcode.editor.cn;
public class StudentAttendanceRecordIi{
    public static void main(String[] args) {
       Solution solution = new StudentAttendanceRecordIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int M = 1000000007;
        int count = 0;
        public int checkRecord(int n) {
            // [Memory Limit Exceeded]暴力递归
//            return recursion(n);
            // dp
//            return dp(n);
            // en
            return en(n);
        }

        private int en(int n) {
            // ending with P or L, no A
            long[] PorL = new long[n + 1];
            // ending with P, no A
            long[] P = new long[n + 1];
            PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

            for (int i = 2; i <= n; i++) {
                P[i] = PorL[i - 1];
                PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
            }

            long res = PorL[n];
            for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
                long s = (PorL[i] * PorL[n - i - 1]) % M;
                res = (res + s) % M;
            }

            return (int) res;
        }

        // 'A' : Absent，缺勤
        // 'L' : Late，迟到
        // 'P' : Present，到场
        private int dp(int n) {
            int mod = (int) (1e9 + 7);
            long[][][] dp = new long[n + 1][2][3];  //[字符串个数][A的个数][L的个数]
            dp[1][1][0] = 1;  //1个A
            dp[1][0][1] = 1;  //1个L
            dp[1][0][0] = 1;  //1个P
            for (int i = 2; i < n + 1; i++) {
                //加A,L清0
                dp[i][1][0] += dp[i - 1][0][0] % mod;  //0A0L上加
                dp[i][1][0] += dp[i - 1][0][1] % mod;  //0A1L上加
                dp[i][1][0] += dp[i - 1][0][2] % mod;  //0A2L上加
                //加P,L清0
                dp[i][0][0] += dp[i - 1][0][0] % mod;  //0A0L上加
                dp[i][0][0] += dp[i - 1][0][1] % mod;  //0A1L上加
                dp[i][0][0] += dp[i - 1][0][2] % mod;  //0A2L上加
                dp[i][1][0] += dp[i - 1][1][0] % mod;  //1A0L上加
                dp[i][1][0] += dp[i - 1][1][1] % mod;  //1A1L上加
                dp[i][1][0] += dp[i - 1][1][2] % mod;  //1A2L上加
                //加L,L累加
                dp[i][0][1] += dp[i - 1][0][0] % mod;  //0A0L上加
                dp[i][0][2] += dp[i - 1][0][1] % mod;  //0A1L上加
                dp[i][1][1] += dp[i - 1][1][0] % mod;  //1A0L上加
                dp[i][1][2] += dp[i - 1][1][1] % mod;  //1A1L上加
            }
            long res = dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2];
            return (int) (res % mod);
        }

        private int recursion(int n) {
            count = 0;
            dfs("", n);
            return count;
        }

        private void dfs(String s, int n) {
            if (n == 0 && checkRecord(s)){
                count = (count + 1) % M;
                return;
            }

            dfs(s + "A", n - 1);
            dfs(s + "L", n - 1);
            dfs(s + "P", n - 1);
        }

        private boolean checkRecord(String s) {
            int count = 0;
            for (int i = 0; i < s.length() && count < 2; i++)
                if (s.charAt(i) == 'A')
                    count++;
            return s.length() > 0 && count < 2 && s.indexOf("LLL") < 0;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}