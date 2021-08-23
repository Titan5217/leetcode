//[86]分隔链表
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 442 👎 0

package com.titan.leetcode.editor.cn;
public class PartitionList{
    public static void main(String[] args) {
       Solution solution = new PartitionList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 双指针
            return solution1(head, x);
        }

        private ListNode solution1(ListNode head, int x) {
            if (head == null){
                return head;
            }
            ListNode smaller = new ListNode();
            ListNode smallPre = smaller;
            ListNode bigger = new ListNode();
            ListNode bigPre = bigger;

            while(head != null){
                if (head.val < x){
                    smaller.next = head;
                    smaller = smaller.next;
                } else {
                    bigger.next = head;
                    bigger = bigger.next;
                }
                head = head.next;
            }

            bigger.next = null;
            smaller.next = bigPre.next;

            return smallPre.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}