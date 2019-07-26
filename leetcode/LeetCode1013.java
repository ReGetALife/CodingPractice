package tk.solidays.algorithm.leetcode;


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
