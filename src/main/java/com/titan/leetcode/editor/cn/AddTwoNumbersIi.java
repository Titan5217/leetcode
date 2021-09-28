//[445]两数相加 II
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
// Related Topics 栈 链表 数学 
// 👍 427 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Stack;

public class AddTwoNumbersIi{
    public static void main(String[] args) {
       Solution solution = new AddTwoNumbersIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            while (l1 != null){
                stack1.push(l1.val);
                l1 = l1.next;
            }
            Stack<Integer> stack2 = new Stack<>();
            while (l2 != null){
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode head = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
                int sum = carry;
                sum += stack1.isEmpty() ? 0 : stack1.pop();
                sum += stack2.isEmpty() ? 0 : stack2.pop();
                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;
                carry = sum / 10;
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}