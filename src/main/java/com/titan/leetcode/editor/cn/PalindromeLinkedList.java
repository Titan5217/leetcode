//[234]回文链表
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 105] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1128 👎 0

package com.titan.leetcode.editor.cn;
public class PalindromeLinkedList{
    public static void main(String[] args) {
       Solution solution = new PalindromeLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode preNode = null;
            ListNode slowNode = head, fastNode = head;
            while (fastNode != null && fastNode.next != null){
                ListNode tmpNode = slowNode.next;
                if (preNode != null){
                    slowNode.next = preNode;
                }
                preNode = slowNode;
                slowNode = tmpNode;
                fastNode = fastNode.next.next;
            }
            if (fastNode != null){
                slowNode = slowNode.next;
            }
            while (slowNode != null){
                if (slowNode.val != preNode.val){
                    return false;
                }
                slowNode = slowNode.next;
                preNode = preNode.next;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}