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
public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
//            1.【不能拷贝额外的数组】遍历，将非零写入新数组，记录0的个数，遍历完成后对0补位
//            2.双指针，记录遍历位置与非0的位置，非0则写到非0指针位置并将当前位置设置为0，时间复杂度O(n)
//            int arrayLength = nums.length;
//            int uZeroIndex = 0;
//            for (int i = 0; i < arrayLength; i ++){
//                if (nums[i] != 0){
//                    nums[uZeroIndex] = nums[i];
//                    if (i > uZeroIndex){
//                        nums[i] = 0;
//                    }
//                    uZeroIndex ++;
//                }
//            }
//            3.雪球，记录雪球大小，遇到0则将雪球加1，非0则与当前位置之前的数据进行替换，时间复杂度O(n)
            int snowSize = 0;
            int arrayLength = nums.length;
            for (int i = 0; i < arrayLength; i ++){
                if (nums[i] == 0){
                    snowSize ++;
                } else if (snowSize > 0){
                    nums[i - snowSize] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}