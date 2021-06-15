package com.titan.leetcode.editor.cn;

/**
 * @author Titan
 * @className Test
 * @description TODO
 * @date 2021/6/15 下午6:34
 */
public class Test {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Test test = new Test();
        System.out.println(test.maxArea(height));
    }

    public int maxArea(int[] height) {
        int arraySize = height.length;

        int maxSize = getArea(Math.min(height[0], height[arraySize - 1]), arraySize - 1);

          for (int i = 0, j = height.length - 1; i < j - 1;){
              if (height[i] > height[j]) {
                  int tmp  = height[j];
                  int aj = j;
                  while (i < aj){
                      if (height[--aj] < tmp){
                          j = aj;
                          break;
                      }
                  }

              } else {
                  int tmp  = height[i];
                  int ai = i;
                  while (ai < j){
                      if (tmp < height[++ai]){
                          i = ai;
                          break;
                      }
                  }
              }

              int minHeight = Math.min(height[i], height[j]);
              maxSize = Math.max(maxSize, getArea(minHeight, j - i));
          }
        return maxSize;
    }

    private int getArea(int heitght, int width) {
        return width * heitght;
    }
}
