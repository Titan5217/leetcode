//[771]宝石与石头
//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。 
//
// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。 
//
// 示例 1: 
//
// 输入: J = "aA", S = "aAAbbbb"
//输出: 3
// 
//
// 示例 2: 
//
// 输入: J = "z", S = "ZZ"
//输出: 0
// 
//
// 注意: 
//
// 
// S 和 J 最多含有50个字母。 
// J 中的字符不重复。 
// 
// Related Topics 哈希表 字符串 
// 👍 653 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones{
    public static void main(String[] args) {
       Solution solution = new JewelsAndStones().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            // map
            return map(jewels, stones);
        }

        private int map(String jewels, String stones) {
            Set<Character> hashSet = new HashSet<>();
            for (int i = 0; i < jewels.length(); i++) {
                hashSet.add(jewels.charAt(i));
            }

            int retCount = 0;
            for (int i = 0; i < stones.length(); i++) {
                if(hashSet.contains(stones.charAt(i))){
                    retCount ++;
                }
            }
            return retCount;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}