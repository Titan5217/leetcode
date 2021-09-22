//[剑指 Offer II 087]复原 IP 
//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
// Related Topics 字符串 回溯 
// 👍 7 👎 0

package com.titan.leetcode.editor.cn;

import java.util.*;

public class ZeroOn3uN{
    public static void main(String[] args) {
       Solution solution = new ZeroOn3uN().new Solution();
       solution.restoreIpAddresses("25525511135");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            // dfs
            int length = s.length();
            List<String> ans = new ArrayList<>();
            if (length < 4 || length > 12){
                return ans;
            }

            dfs(s, length, 0,4, new LinkedList<String>(), ans);

            return ans;
        }

        private void dfs(String s, int length, int index, int paragraph, LinkedList<String> path, List<String> ans) {
            if (index == length){
                if(paragraph == 0){
                    ans.add(String.join(".", path));
                }
                return;
            }

            for (int i = index; i < index + 3; i++) {
                if (i >= length){
                    break;
                }
                if (paragraph * 3 < length - i){
                    continue;
                }
                if (judgeIpSegment(s, index, i)){
                    path.addLast(s.substring(index, i + 1));
                    dfs(s, length, i + 1, paragraph - 1, path, ans);
                    path.removeLast();
                }
            }
        }

        private boolean judgeIpSegment(String s, int begin, int end) {
            int len = end - begin + 1;
            if (len > 1 && s.charAt(begin) == '0'){
                return false;
            }
            int res = 0;
            while (begin <= end){
                res = res * 10 + s.charAt(begin) - '0';
                begin ++;
            }
            return res >= 0 && res <= 255;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}