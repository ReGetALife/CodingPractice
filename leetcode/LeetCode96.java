package tk.solidays.algorithm.leetcode;

import java.math.BigInteger;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode96 {
    /*
     * 设以1到n的二叉搜索树为G(n)，那么我们依次以i为根节点，可以得到G(n)=Σ(G(i-1)*G(n-i))，G(0)=1
     * G(n)是Catalan数
     * G(n)等于从2n个数中取n个数的组合减去从2n个数中取n+1个数的组合
     * G(n)的另一个递推式G(n+1)=2(2n+1)*G(n)/(n+2)
     */
    public int numTrees(int n) {
        //BigInteger ans = BigInteger.valueOf(1);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = 2 * (2 * i + 1) * ans / (i + 2);
            //ans = ans.multiply(BigInteger.valueOf(2 * (2 * i + 1))).divide(BigInteger.valueOf(i + 2));
        }
        return (int) ans;
    }
}
