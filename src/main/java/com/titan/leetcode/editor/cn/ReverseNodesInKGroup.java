//[25]K 个一组翻转链表
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1138 👎 0

package com.titan.leetcode.editor.cn;
public class ReverseNodesInKGroup{
    public static void main(String[] args) {
       Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // 递归法。。。

            // 指针法
            // 问题缩小
            // 将数据按k做分组，每组单独进行翻转
            ListNode dummy = new ListNode();
            dummy.next = head;

            // 外层，根指针 dummy
            // 外层，k节点开始指针 preNode
            // 外层，k节点结束指针 endNode
            // 外层，后续节点指针 aftNode
            // 内层

            ListNode preNode = dummy; //头指针
            ListNode endNode = dummy; //尾指针
            while (endNode.next != null){
                // 从前向后取k个节点
                for (int i = 0; i < k && endNode != null; i++) {
                    endNode = endNode.next;
                }
                if (endNode == null){
                    break;
                }

                //1.取得k个节点后的指针，防止丢失
                ListNode start = preNode.next;
                ListNode next = endNode.next;
                endNode.next = null;
                //2. revery k个节点数据
                preNode.next = recovery(start);
                //3.外层前指针的next
                start.next = next;
                endNode = preNode = start;
            }

            return dummy.next;
        }

        private ListNode recovery(ListNode head) {
            ListNode pre = null;
            ListNode current = head;
            while (current != null){
                ListNode tmp = current.next;
                current.next = pre;
                pre = current;
                current = tmp;
            }
            return pre;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}