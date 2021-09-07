//[剑指 Offer 37]序列化二叉树
//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
// 👍 231 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class XuLieHuaErChaShuLcof{
//    public static void main(String[] args) {
//       Solution solution = new XuLieHuaErChaShuLcof().new Solution();
//    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Codec {
        private final String splider = ",";
        private final String NotANode = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            serialize(root, builder);
            return builder.toString();
        }

        private void serialize(TreeNode root, StringBuilder builder) {
            if (root == null){
                builder.append(NotANode).append(splider);
            } else {
                builder.append(root.val).append(splider);
                serialize(root.left, builder);
                serialize(root.right, builder);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(data.split(splider)));
            return deserialize(queue);
        }

        private TreeNode deserialize(Queue<String> queue) {
            String nodeStr = queue.poll();
            if (nodeStr.equalsIgnoreCase(NotANode)){
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(nodeStr));
            node.left = deserialize(queue);
            node.right = deserialize(queue);
            return node;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

}