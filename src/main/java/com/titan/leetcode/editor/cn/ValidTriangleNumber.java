//[611]有效三角形的个数
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 217 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;

public class ValidTriangleNumber{
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int triangleNumber(int[] nums) {
            // 暴力迭代，dfs
//            return iterator(nums);
            // 有两个边后，第三第边可采取区间查找
//            return erfen(nums);
            // 排序，双指针
            return doublePoint(nums);
        }

        private int doublePoint(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length;
            int ans = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i - 1, k = 0; k < j; j--) {
                    while (k < j && nums[k] + nums[j] <= nums[i]){
                        k ++;
                    }
                    ans += j - k;
                }
            }
            return ans;
        }

        private int erfen(int[] nums) {
            Arrays.sort(nums);

            int ans = 0;
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    int l = j + 1, r = length - 1, k = j;
                    while (l <= r){
                        int mid = (l + r) / 2;
                        if (nums[mid] < nums[i] + nums[j]){
                            l = mid + 1;
                            k = mid;
                        } else {
                            r = mid - 1;
                        }
                    }
                    ans += k - j;
                }
            }

            return ans;
        }

        private int iterator(int[] nums) {
            int length = nums.length;
            if (length < 3){
                return 0 ;
            }

            int ans = 0;
            for (int i = 0; i < length - 2; i++) {
                if (nums[i] == 0){
                    continue;
                }
                for (int j = i + 1; j < length - 1; j++) {
                    if (nums[j] == 0){
                        continue;
                    }
                    for (int k = j + 1; k < length; k++) {
                        if (nums[k] == 0){
                            continue;
                        }
                        if (isATrangle(nums[i], nums[j], nums[k])){
                            ans ++;
                        }
                    }
                }
            }
            return ans;
        }

        private boolean isATrangle(int num, int num1, int num2) {
            return num + num1 > num2 && Math.abs(num - num1) < num2 ? true : false;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}