//[429]N 叉树的层序遍历
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 159 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            // 广度优先迭代，一层一层的处理
            List<List<Integer>> retList = new ArrayList<>();

            Queue<Node> childList = new LinkedList<Node>();
            childList.add(root);
            while (!childList.isEmpty()){
                List<Integer> tmpList = new ArrayList<>();
                int size = childList.size();
                for (int i = 0; i < size; i++) {
                    Node tmpNode = childList.poll();
                    tmpList.add(tmpNode.val);
                    childList.addAll(tmpNode.children);
                }
                retList.add(tmpList);
            }

            return retList;

            // 带层级的递归处理
//            List<List<Integer>> retList = new ArrayList<>();
//
//            if (root != null){
//                breadthFirst(root, 0, retList);
//            }
//
//            return retList;
        }

        private void breadthFirst(Node root, int level, List<List<Integer>> retList) {
            if (retList.size() <= level){
                retList.add(new ArrayList<>());
            }

            retList.get(level).add(root.val);

            for (Node child : root.children) {
                breadthFirst(child, level + 1, retList);
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}