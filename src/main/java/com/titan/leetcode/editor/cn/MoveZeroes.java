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
    // solution1: 遍历nums,记录0的个数，再将遍历，将非0的写入，补位多个0；循环多，效率低
    // solution2: 遍历nums,将非0的数写入新数组，补0；循环多，效率低

    // solution4: 遍历nums,position为size；不可行，影响顺序
//    public void moveZeroes(int[] nums) {
//        int size = nums.length;
//        int j = size - 1;
//        for (int i = 0; i < size; i ++){
//            if (nums[i] == 0){
//                nums[i] = nums[j];
//                if (i > j){
//                    break;
//                }
//                nums[j] = 0;
//                j --;
//            }
//        }
//    }

  // solution3: 遍历nums,将非0的前移，并记录位置，将当前值设置为0
    public void moveZeroes(int[] nums) {
        if (null == nums){
            return;
        }

        int j = 0;
        int size = nums.length;
        for (int i = 0; i < size; i ++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i > j){
                    nums[i] = 0;
                }
                j ++;
            }
        }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}