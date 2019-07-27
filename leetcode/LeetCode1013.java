package tk.solidays.algorithm.leetcode;

/**
 * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int n = A.length;
        int[] sum = new int[n];
        sum[0] = A[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        for (int i : sum)
            System.out.println(i);
        if (sum[n - 1] % 3 != 0)
            return false;
        int a = (sum[n - 1] / 3);
        for (int i = 0; i < n; i++) {
            if (sum[i] == a){
                for (int j = i + 1; j < n; j++) {
                    if (sum[j] == (2 * a))
                        return true;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        new LeetCode1013().canThreePartsEqualSum(nums);

    }
}
