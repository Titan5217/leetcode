package com.titan.leetcode.editor.cn;

/**
 * @author Titan
 * @className Test
 * @description TODO
 * @date 2021/6/15 下午6:34
 */
public class Test {
    public static void main(String[] args) {
        int[] height = {-3,4,3,90};
        Test test = new Test();
        System.out.println(test.twoSum(height, 0));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] retNums = new int[2];

        int arraySize = nums.length;
        // solution1: 暴力法
        for (int i = 0; i < arraySize - 1; i ++){
            for (int j = i + 1; j < arraySize; j ++){
                if (nums[i] + nums[j] == target){
                    retNums[0] = i;
                    retNums[1] = j;
                    return retNums;
                }
            }
        }

        // solution2: hash法

        return retNums;
    }
}
