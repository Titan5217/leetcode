//[283]移动零
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1083 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // []两次循环，第一次取出非1的下标，第二次写入 O(n)
//            if (nums == null || nums.length == 0){
//                return ;
//            }
//            List<Integer> notZeroIndex = new ArrayList();
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != 0){
//                    notZeroIndex.add(i);
//                }
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if (i < notZeroIndex.size()){
//                    nums[i] = nums[notZeroIndex.get(i)];
//                } else {
//                    nums[i] = 0;
//                }
//            }
            // 快慢指针 O(n)
//            if (null == nums || nums.length <= 1){
//                return;
//            }
//            int j = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != 0){
//                    nums[j] = nums[i];
//                    if (i >  j){
//                        nums[i] = 0;
//                    }
//                    j ++;
//                }
//            }

            // 雪球 O(n)
            if (nums == null || nums.length == 1){
                return;
            }
            int snowSize = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0){
                    snowSize ++;
                    continue;
                }
                nums[i - snowSize] = nums[i];
                if (snowSize > 0){
                    nums[i] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}