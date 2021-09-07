//[剑指 Offer 06]从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 178 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
       Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode currentNode = head;
            while (currentNode != null){
                stack.push(currentNode.val);
                currentNode = currentNode.next;
            }

            int size = stack.size();
            int[] ans  = new int[size];
            for (int i = 0; i < size; i++) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}