//[143]重排链表
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 675 👎 0

package com.titan.leetcode.editor.cn;
public class ReorderList{
    public static void main(String[] args) {
       Solution solution = new ReorderList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null){
                return;
            }
            ListNode midNode = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = midNode.next;
            midNode.next = null;
            l2 = reverseList(l2);
            mergeList(l1, l2);
        }

        private void mergeList(ListNode l1, ListNode l2) {
            ListNode t1, t2;
            while (l1 != null && l2 != null){
                t1 = l1.next;
                t2 = l2.next;

                l1.next = l2;
                l1 = t1;

                l2.next = l1;
                l2 = t2;
            }
        }

        private ListNode reverseList(ListNode l2) {
            ListNode preNode = null;
            ListNode currentNode = l2;
            while (currentNode != null){
                ListNode tmpNode = currentNode.next;
                currentNode.next = preNode;
                preNode = currentNode;
                currentNode = tmpNode;
            }
            return preNode;
        }

        private ListNode middleNode(ListNode head) {
            ListNode slowNode = head;
            ListNode fastNode = head;
            while (fastNode.next != null && fastNode.next.next != null){
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
            return slowNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}