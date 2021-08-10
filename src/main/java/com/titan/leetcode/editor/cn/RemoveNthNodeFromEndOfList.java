//[19]删除链表的倒数第 N 个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1493 👎 0

package com.titan.leetcode.editor.cn;
public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
       solution.removeNthFromEnd(ListNode.InitList(new Integer[]{1}), 1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 循环一次取得链表长度l，再次循环取得l-n对应的节点，删除 时间：O(n2)；空间：O(1)
            // 循环的过程中记录节点指针，待到循环一次完成可取到对应的节点 时间：O(n)；空间：O(n)

            // 双指针，快的到n开始，慢的开始随之增加，当循环完成，则返回 时间：O(n)；空间：O(1)
            return solution3(head, n);
        }

        private ListNode solution3(ListNode head, int n) {
            int i = 0, j = 0;

            ListNode currentNode = head;
            ListNode preNode = head;
            while (currentNode != null){
                if (i > n){
                    preNode = preNode.next;
                }
                i ++;
                currentNode = currentNode.next;
            }

            // 数组长度等于节点长度，删除头节点
            if (i == n){
                head = head.next;
            } else if (preNode.next != null){
                preNode.next = preNode.next.next;
            }

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}