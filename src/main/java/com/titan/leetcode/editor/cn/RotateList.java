//[61]旋转链表
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 608 👎 0

package com.titan.leetcode.editor.cn;
public class RotateList{
    public static void main(String[] args) {
       Solution solution = new RotateList().new Solution();
        solution.rotateRight(ListNode.InitList(new Integer[]{1,2,3,4,5}), 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // 不知道有多少节点，一次循环后，记录节点数，用k整除，减枝
            // 单次循环，区间性的记录一些节点指针
            // 造环
            return solution1(head, k);
        }

        private ListNode solution1(ListNode head, int k) {
            if (head == null){
                return head;
            }

            int count = 0;
            ListNode preNode = new ListNode(0, head);
            while (preNode.next != null){
                preNode = preNode.next;
                count ++;
            }
            preNode.next = head; //成环
            k %= count;
            k = count - k;
            while (k > 0){
                preNode = preNode.next;
                head = head.next;
                k --;
            }
            preNode.next = null;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}