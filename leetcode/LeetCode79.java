package tk.solidays.algorithm.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode79 {
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        if (word.length() == 0)
            return true;
        if (board.length == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && recursion(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean recursion(int i, int j, int pos) {
        //能继续走
        if (board[i][j] == word.charAt(pos)) {
            if (pos == word.length() - 1)
                return true;
            else {
                char c = board[i][j];
                board[i][j] = '#';
                //往四个方向走
                if (i - 1 >= 0 && recursion(i - 1, j, pos + 1))
                    return true;
                if (j - 1 >= 0 && recursion(i, j - 1, pos + 1))
                    return true;
                if (i + 1 < board.length && recursion(i + 1, j, pos + 1))
                    return true;
                if (j + 1 < board[0].length && recursion(i, j + 1, pos + 1))
                    return true;
                board[i][j] = c;
            }
        }
        return false;
    }
}
