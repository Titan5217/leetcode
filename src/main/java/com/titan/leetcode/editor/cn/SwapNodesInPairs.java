//[24]两两交换链表中的节点
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 941 👎 0

package com.titan.leetcode.editor.cn;
public class SwapNodesInPairs{
    public static void main(String[] args) {
       Solution solution = new SwapNodesInPairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // 遍历
//            ListNode retNode = new ListNode();
//            retNode.next = head;
//            ListNode currNode = retNode;
//
//            while (currNode.next != null && currNode.next.next != null){
//                ListNode tmpNode1 = currNode.next;
//                ListNode tmpNode2 = currNode.next.next;
//
//                currNode.next = tmpNode2;
//                tmpNode1.next = tmpNode2.next;
//                tmpNode2.next = tmpNode1;
//                currNode = tmpNode1;
//            }
//
//            return retNode.next;

            // 递归
            if (head == null || head.next == null){
                return head;
            }

            ListNode retNode = head.next;
            head.next = swapPairs(retNode.next);
            retNode.next = head;

            return retNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}