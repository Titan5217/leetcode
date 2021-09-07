//[剑指 Offer 24]反转链表
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 
// 👍 293 👎 0

package com.titan.leetcode.editor.cn;
public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
       Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null){
                return head;
            }
            ListNode preNode = new ListNode(0, head);

            ListNode tmpNode = head.next;
            while (tmpNode != null){
                head.next = tmpNode.next;
                tmpNode.next = preNode.next;
                preNode.next = tmpNode;

                tmpNode = head.next;
            }

            return preNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}