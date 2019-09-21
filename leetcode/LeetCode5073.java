package tk.solidays.algorithm.leetcode;

import java.util.*;

public class LeetCode5073 {
    private int x;
    private int y;
    int minDeep = Integer.MAX_VALUE;
    Map<String, Integer> memo = new HashMap<>();

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        this.x = Math.min(x,y);
        this.y = Math.max(x,y);

        return recursion(0, 0, 0);
    }

    //该方法实际上是优先往左1上2方走
    private int recursion(int i, int j, int deep) {
        if (deep >= minDeep || deep > 300)
            return minDeep;
        if (i == x && j == y) {
            minDeep = Math.min(deep, minDeep);
            return deep;
        }
        if (memo.containsKey(i + "," + j))
            return memo.get(i + "," + j);
        int ans;
        if (i <= x && j <= y) {
            ans = Math.min(recursion(i + 1, j + 2, deep + 1), recursion(i + 2, j + 1, deep + 1));
        } else if (i >= x && j <= y) {
            ans = Math.min(recursion(i - 1, j + 2, deep + 1), recursion(i - 2, j + 1, deep + 1));
        } else if (i <= x) {
            ans = Math.min(recursion(i + 1, j - 2, deep + 1), recursion(i + 2, j - 1, deep + 1));
        } else {
            ans = Math.min(recursion(i - 1, j - 2, deep + 1), recursion(i - 2, j - 1, deep + 1));
        }
        if (memo.containsKey(i + "," + j)) {
            ans = Math.min(ans, memo.get(i + "," + j));
        }
        memo.put(i + "," + j, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5073().minKnightMoves(8, 0));
        System.out.println(new LeetCode5073().minKnightMoves(0, 8));
        System.out.println(new LeetCode5073().minKnightMoves(2, 112));
        System.out.println(new LeetCode5073().minKnightMoves(112, 2));
        System.out.println(new LeetCode5073().minKnightMoves(270, 21));
        System.out.println(new LeetCode5073().minKnightMoves(21, 270));
        System.out.println(new LeetCode5073().minKnightMoves(0, 228));
    }
}
