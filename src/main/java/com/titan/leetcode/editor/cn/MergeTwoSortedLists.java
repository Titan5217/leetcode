//[21]合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1758 👎 0

package com.titan.leetcode.editor.cn;
public class MergeTwoSortedLists{
    public static void main(String[] args) {
    Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // while循环
            ListNode retPreNode = new ListNode();

            ListNode preNode = retPreNode;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    preNode.next = l1;
                    l1 = l1.next;
                } else {
                    preNode.next = l2;
                    l2 = l2.next;
                }
                preNode = preNode.next;
            }

            preNode.next = l1 == null ? l2 : l1;

            return retPreNode.next;

            // 递归
//            if (l1 == null) {
//                return l2;
//            } else if (l2 == null) {
//                return l1;
//            } else if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
        }
    }
     public class ListNode {
         int val;
         ListNode next;

         ListNode() {
         }

         ListNode(int val) {
             this.val = val;
         }

         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }
    //leetcode submit region end(Prohibit modification and deletion)

}