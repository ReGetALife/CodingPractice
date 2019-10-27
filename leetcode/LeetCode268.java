package tk.solidays.algorithm.leetcode;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode268 {
    //法一
    //0到n-1的数让对应的下标变为之前的相反数-1。也就是出现过的数对应的位置都是负数（考虑了0所以减一）。
    //特殊处理n
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int origin;
        for (int i = 0; i < nums.length; i++) {
            origin = nums[i] < 0 ? -(nums[i] + 1) : nums[i];
            if (origin == n) n = -n;
            else nums[origin] = -nums[origin] - 1;
        }
        if (n > 0) return n;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }
        return -1;
    }

    //法二：利用0到n-1的下标和和0到n的数和的关系求到不出现的数。可以把每个数和对应的下标相减再得到累计的结果，也可以全加起来再减（可能溢出）。
    //法三：利用0到n-1的下标和0到n的数之间的全部异或，得到不出现的数。
    public int missingNumber3(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i] ^ i;
        }
        return ans;
    }
}
