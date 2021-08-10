//[23]合并K个升序链表
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1438 👎 0

package com.titan.leetcode.editor.cn;
public class MergeKSortedLists{
    public static void main(String[] args) {
       Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // 每次都与返回结果进行两两合并
//            return solution1(lists);
            
            // 分治
            return solution2(lists);

            // 优先队列

        }

        private ListNode solution2(ListNode[] lists) {
            if (lists.length == 0){
                return null;
            }

            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right){
                return lists[left];
            }
            int mid = (left + right) / 2;
            ListNode l0 = merge(lists, left, mid);
            ListNode l1 = merge(lists, mid + 1, right);

            return mergeTwoNodes(l0, l1);
        }

        private ListNode solution1(ListNode[] lists) {
            ListNode retNode = null;
            for (int i = 0; i < lists.length; i++) {
                retNode = mergeTwoNodes(retNode, lists[i]);
            }
            return retNode;
        }

        private ListNode mergeTwoNodes(ListNode aNode, ListNode bNode) {
            if (aNode == null || bNode == null){
                return aNode == null ? bNode : aNode;
            }

            ListNode head = new ListNode(0);
            ListNode curr = head;
            ListNode currentA = aNode;
            ListNode currentB = bNode;
            while (currentA != null && currentB != null){
                if (currentA.val < currentB.val){
                    curr.next = currentA;
                    currentA = currentA.next;
                } else {
                    curr.next = currentB;
                    currentB = currentB.next;
                }
                curr = curr.next;
            }
            curr.next = currentA == null ? currentB : currentA;
            return head.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}