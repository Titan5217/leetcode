//[剑指 Offer 22]链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 227 👎 0

package com.titan.leetcode.editor.cn;
public class LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
       Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            // 先取得节点数，后再次迭代取出第size-k的值
            int n = 0;
            ListNode node = null;
            for (node = head;  node != null ; node = node.next) {
                n ++;
            }
            for (node = head; n > k ; n --) {
                node = node.next;
            }
            return node;
//            // 快慢指针
//            ListNode fast = head;
//            while (fast != null && k > 0){
//                fast = fast.next;
//                k --;
//            }
//
//            if (k > 0){
//                return null;
//            }
//
//            ListNode slow = head;
//            while (fast != null){
//                fast = fast.next;
//                slow = slow.next;
//            }
//            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}