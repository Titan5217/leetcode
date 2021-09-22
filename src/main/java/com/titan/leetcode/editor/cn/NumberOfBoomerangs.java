//[447]回旋镖的数量
//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 
// 👍 168 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs{
  public static void main(String[] args) {
       Solution solution = new NumberOfBoomerangs().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 计算长度以及对应个数，取排列结果
        int ans = 0;
        for (int[] pointX : points) {
            Map<Integer, Integer> tmpMap = new HashMap<>();
            for (int[] pointY : points) {
                int distance = (pointX[0] - pointY[0]) * (pointX[0] - pointY[0]) + (pointX[1] - pointY[1]) * (pointX[1] - pointY[1]);
                tmpMap.put(distance, tmpMap.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entity: tmpMap.entrySet()) {
                int count = entity.getValue();
                ans += count * (count - 1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}