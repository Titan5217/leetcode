//[142]环形链表 II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 1032 👎 0

package com.titan.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIi{
    public static void main(String[] args) {
       Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode detectCycle(ListNode head) {
//            hash法【不满足进阶要求】
//            Set<ListNode> tmpSet = new HashSet<ListNode>();
//            ListNode step = head;
//            while (step != null){
//                if (tmpSet.contains(step)){
//                    return step;
//                } else {
//                    tmpSet.add(step);
//                }
//                step = step.next;
//            }
//            return null;

            // 指针法
            // 假设环外长度为a,环上长度为n,当快指针与慢指针第一次相遇时，环上走了的长度为b
            // 快指针走的步数是慢指针的2倍 ( a + b ) * 2 = a + n + b + 1
            // 得a + b = n + 1
            // a = n - b + 1 所以在快指针与慢指针相遇后，再从head节点出发一个指针，速度与慢指针一样，则会与快指针在第一个重叠点相遇
            if (head == null){
                return head;
            }

            boolean isCycle = false;

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null &&  fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    isCycle = true;
                    break;
                }
            }

            if (!isCycle){
                return null;
            }

            fast = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            return fast;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}