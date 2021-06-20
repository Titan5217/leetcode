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
// 👍 1089 👎 0

package com.titan.leetcode.editor.cn;
public class MoveZeroes{
    public static void main(String[] args) {
       Solution solution = new MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 记录补位
            int position = 0;
            for (int num: nums) {
                if (num != 0){
                    nums[position ++] = num;
                }
            }
            while (position < nums.length){
                nums[position ++] = 0;
            }
            // 快慢指针
//            for (int i = 0, j = 0; i < nums.length; i++) {
//                if (nums[i] != 0){
//                    nums[j ++] = nums[i];
//                    if (i >= j){
//                        nums[i] = 0;
//                    }
//                }
//            }
            // 雪球
//            int snowSize = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == 0){
//                    snowSize++;
//                } else if (snowSize > 0) {
//                    int tmp = nums[i - snowSize];
//                    nums[i - snowSize] = nums[i];
//                    nums[i] = tmp;
//                }
//            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}