package com.titan.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Titan
 * @className TreeNode
 * @description TODO
 * @date 2021/7/31 下午4:02
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode InitList(Integer[] vals) {
        ListNode root = new ListNode(vals[0]);
        Queue<ListNode> queue = new LinkedList<>();
        int cur = 1;
        int length = vals.length;
        queue.offer(root);
        while (queue != null) {
            ListNode r = queue.poll();
            if (cur == length){
                break;
            } else if (vals[cur] == null) {
                r.next=null;
            } else {
                r.next = new ListNode(vals[cur]);
                queue.offer(r.next);
            }
            if (++cur >= vals.length) {
                break;
            }
        }
        return root;
    }
}
