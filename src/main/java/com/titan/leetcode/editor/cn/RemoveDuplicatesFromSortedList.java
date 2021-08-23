//[83]删除排序链表中的重复元素
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 
// 👍 627 👎 0

package com.titan.leetcode.editor.cn;
public class RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null){
                return head;
            }
            ListNode pre = new ListNode(0, head);
            ListNode currentNode = head;
            while (currentNode != null && currentNode.next != null){
                if (currentNode.val == currentNode.next.val){
                    int val = currentNode.val;
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