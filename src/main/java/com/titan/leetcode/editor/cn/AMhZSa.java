//[剑指 Offer II 027]回文链表
//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 105] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 
// 👍 5 👎 0

package com.titan.leetcode.editor.cn;
public class AMhZSa{
    public static void main(String[] args) {
       Solution solution = new AMhZSa().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 快慢指针
            ListNode pre = null;
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null){
                ListNode tmpNode = slow.next;
                if(pre != null) {
                    slow.next = pre;
                }
                pre = slow;
                slow = tmpNode;
                fast = fast.next.next;
            }
            if (fast != null){
                slow = slow.next;
            }
            while (slow != null){
                if (slow.val != pre.val){
                    return false;
                }
                slow = slow.next;
                pre = pre.next;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}