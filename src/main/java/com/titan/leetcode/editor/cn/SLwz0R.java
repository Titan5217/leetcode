//[剑指 Offer II 021]删除链表的倒数第 n 个结点
//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
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
//
// 
//
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-of
//-list/ 
// Related Topics 链表 双指针 
// 👍 5 👎 0

package com.titan.leetcode.editor.cn;
public class SLwz0R{
    public static void main(String[] args) {
       Solution solution = new SLwz0R().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode currentNode = head;
            ListNode preNode = head;
            int index = 0;
            while (currentNode != null){
                if (index > n){
                    preNode = preNode.next;
                }
                index ++;
                currentNode = currentNode.next;
            }

            if (index == n){
                head = head.next;
            } else if (preNode.next != null){
                preNode.next = preNode.next.next;
            }

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}