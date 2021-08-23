//[82]删除排序链表中的重复元素 II
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 
// 👍 684 👎 0

package com.titan.leetcode.editor.cn;
public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 双指针
            return solution1(head);
        }

        private ListNode solution1(ListNode head) {
            if (head == null){
                return head;
            }
            ListNode pre = new ListNode(0, head);
            ListNode currentNode = pre;
            while (currentNode.next != null && currentNode.next.next != null){
                if (currentNode.next.val == currentNode.next.next.val){
                    int val = currentNode.next.val;
                    while (currentNode.next != null && currentNode.next.val == val){
                        currentNode.next = currentNode.next.next;
                    }
                } else {
                    currentNode = currentNode.next;
                }
            }

            return pre.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}