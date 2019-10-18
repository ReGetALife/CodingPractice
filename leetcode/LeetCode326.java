package tk.solidays.algorithm.leetcode;

import java.util.concurrent.ConcurrentHashMap;

public class LeetCode326 {
    //1162261467是int范围内最大的3的幂，3是质数，所以3的幂的因子只能是3的幂
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
