//[297]二叉树的序列化与反序列化
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 581 👎 0

package com.titan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
    }
  //leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

    //
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
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}