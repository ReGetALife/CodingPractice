package tk.solidays.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode89 {
    //法一：一位一位添加，倒序遍历之前结果，在之前的所有结果基础上加一个高位的1
    //法二：公式法，遍历从0到2^n-1，最高位保留，其它位是当前位和它的高一位进行异或操作，即 G(i) = i ^ (i/2)。
    public List<Integer> grayCode(int n) {
        int m = 1 << n;
        Integer[] ans = new Integer[m];
        for (int i = 0; i < m; i++) {
            ans[i]=i ^ (i >> 1);
        }
        return Arrays.asList(ans);
    }
}
