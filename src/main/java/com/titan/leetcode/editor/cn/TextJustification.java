//[68]文本左右对齐
//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 模拟 
// 👍 145 👎 0

package com.titan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TextJustification{
    public static void main(String[] args) {
       Solution solution = new TextJustification().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            // 对这种类型的题，恶心得不得了
            final String[] space = new String[maxWidth+1];
            StringBuffer s = new StringBuffer();
            for(int i = 0;i<maxWidth+1;i++){
                space[i] = s.toString();
                s.append(" ");
            }
            //新建List，用来存最后的结果。
            List<String> pWords = new ArrayList<String>();
            //遍历整个words，一行一行的排版     
            for(int i=0; i<words.length; i++){
                int curlen = words[i].length(); //记录当前已读取单词的长度，当>=maxWidth时进行排版
                int startI = i;                //记录本次读取单词的起点
                while(i < words.length-1 && curlen<maxWidth){
                    i++;
                    curlen = curlen+words[i].length()+1;  // 每多读一个单词都要加一个空格
                }
                if(curlen>maxWidth){       //当前长度>maxWidth，说明已经多读取了一个单词
                    curlen = curlen-words[i].length()-1;
                    i--;
                }
                //一行一行的排版
                pWords.add(processCurline(words,startI,i,curlen,maxWidth,space));
            }
            return pWords;
        }
        public String processCurline(String[] words,int si,int ei,int curlen,int maxWidth,String[] space){
            StringBuffer sb = new StringBuffer();   //用来进行排版
            int gap = ei-si;                   // 记录单词之间的有几个间隙
            int addSpace = maxWidth - curlen+gap;   //记录这一行总共有多少个空格
            if(gap==0){               //间隙为0，证明只有一个单词
                sb.append(words[ei]);
                sb.append(space[addSpace]);
                return sb.toString();
            }
            if(ei == words.length-1){            //证明要排版最后一行了，格式特殊
                for(int i =si;i<ei;i++){
                    sb.append(words[i]).append(" ");
                }
                sb.append(words[ei]);             //最后一个单词不用加空格 
                sb.append(space[addSpace-gap]);   //如果还有多余空格，一起加上
                return sb.toString();
            }
            int allAddSpace = addSpace/gap;     //所有的空格数 / 间隙 = 每个间隙必加的空格数
            int left = addSpace % gap + si;     //多出来的空格要从si开始，依次加在间隙中
            for(int i = si;i<ei;i++){
                sb.append(words[i]).append(space[allAddSpace]);
                if(i < left) sb.append(" ");     // <left就要多加一个空格
            }
            sb.append(words[ei]);
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}