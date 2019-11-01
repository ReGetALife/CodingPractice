package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//将单词放入前缀树中，然后从每个二维矩阵中的字符开始回溯查找，前缀不匹配立即停止。耗时15 ms。
public class LeetCode212 {
    class TrieNode {
        boolean isEnd = false;
        boolean isAdded = false;
        TrieNode[] links = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();
    private List<String> ans = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private char[][] board;

    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (current.links[c] == null) {
                current.links[c] = new TrieNode();
                current = current.links[c];
            } else {
                current = current.links[c];
            }
        }
        current.isEnd = true;
    }

    private void backTrace(int i, int j, TrieNode current) {
        int p = board[i][j] - 'a';
        if (p >= 0 && current.links[p] != null) {//前缀存在
            current = current.links[p];
            sb.append(board[i][j]);
            if (current.isEnd && !current.isAdded) {
                ans.add(sb.toString());
                current.isAdded = true;
            }
            //防止往回走
            char c = board[i][j];
            board[i][j] = (char) ('a' - 10);
            //往四个方向走
            if (i - 1 >= 0)
                backTrace(i - 1, j, current);
            if (j - 1 >= 0)
                backTrace(i, j - 1, current);
            if (i + 1 < board.length)
                backTrace(i + 1, j, current);
            if (j + 1 < board[0].length)
                backTrace(i, j + 1, current);
            board[i][j] = c;
            sb.replace(sb.length() - 1, sb.length(), "");
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) return ans;
        this.board = board;
        for (String word : words) insert(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backTrace(i, j, root);
            }
        }
        return ans;
    }
}
