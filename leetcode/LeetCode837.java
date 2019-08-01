package tk.solidays.algorithm.leetcode;

/**
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * <p>
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * <p>
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 示例 2：
 * <p>
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 示例 3：
 * <p>
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * 提示：
 * <p>
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/new-21-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * f(n)表示点数为n的概率，若不考虑K
 * f(n)=f(n-1)/w + f(n-2)/w + ... + f(n-w)/w (w项)
 * 这个公式怎么得来的呢？ 例如: w为5,n为20，则20只可能由[15,16,17,18,19]中的某个数加上[1,5]的某个数，经过1步出来的。
 * 因此P(20)为以下各项概率之和：
 * <p>
 * P(19)*N(1)的概率
 * P(18)*N(2)的概率
 * P(17)*N(3)的概率
 * P(16)*N(4)的概率
 * P(15)*N(5)的概率
 * N(i)表示刚好出现i的概率
 * 此时再考虑上K，同样以w=5，k=17，n=20为例。 因为17、18、19已经大于或等于k，因此20不可能由17、18、19得来，此时 P(20)为以下各项概率之和：
 * <p>
 * P(19)*N(1)的概率
 * P(18)*N(2)的概率
 * P(17)*N(3)的概率
 * P(16)*N(4)的概率
 * P(15)*N(5)的概率
 * N(i)表示刚好出现i的概率
 * 由此可知：
 * P(n)最多与其之前的w项相关， 并且需要排除掉n>=k的项目，因此可以得到与P(n)相关的的项的范围为：[max(0,n-w),min(n-1,k-1)] ，其小值设为：left，大值设为：right，则递推公式可以表示为：
 * f(n)=f(min)/w + f(min+1)/w + f(min+2)/w + ... + f(max-1)/w+f(max)/w
 * 其结果为最终可能的数的概率和，即：所有大于等于K并且小于等于N的数的概率之和
 * <p>
 * var new21Game = function(N, K, W) {
 * let dp = new Array(N+1).fill(0);
 * let sumArr = new Array(N+1).fill(0);
 * dp[0]=1;
 * for(let n=1;n<=N;n++){
 * let left = Math.max(0,n-W);
 * let right = Math.min(n-1,K-1);
 * let p=0
 * for(let i=left;i<=right;i++){
 * p+=dp[i]/W;
 * }
 * dp[n]=p;
 * sumArr[n]=sumArr[n-1]+p;
 * }
 * let result = 0;
 * for(let i=K;i<=N;i++){
 * result+=dp[i]
 * }
 * return result;
 * };
 * 考虑到求和还需要遍历一次dp数组，因此不妨再设一个sumArr记录前n项的概率和，然后考虑K===0和K===1的情况最终答案为：
 * <p>
 * var new21Game = function(N, K, W) {
 * if(K===0)return 1;
 * if(K===1)return Math.min(N,W)/W;
 * let dp = new Array(N+1).fill(0);
 * let sumArr = new Array(N+1).fill(0);
 * dp[0]=1;
 * for(let n=1;n<=N;n++){
 * let left = Math.max(0,n-W);
 * let right = Math.min(n-1,K-1);
 * let p=(sumArr[right]-sumArr[left]+dp[left])/W
 * dp[n]=p;
 * sumArr[n]=sumArr[n-1]+p;
 * }
 * return sumArr[N]-sumArr[K-1];
 * };
 * 时间复杂度为：O(n)
 * 空间复杂度为：O(2n)
 * <p>
 * 作者：wanyan
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/di-tui-gong-shi-yi-ji-xiang-xi-jie-ti-si-lu-by-wan/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode837 {
    public double new21Game(int N, int K, int W) {
        if (K - 1 + W <= N || K == 0)
            return 1.0;
        double[] dp = new double[N + 1];//dp[i]指得到点数为i的概率
        double[] sum = new double[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {//和为i
            int left = Math.max(0, i - W);
            int right = Math.min(i - 1, K - 1);
            dp[i] = (sum[right] - sum[left] + dp[left]) / W;
            sum[i] = sum[i - 1] + dp[i];
        }
        return sum[N] - sum[K - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode837().new21Game(3, 2, 10));
        System.out.println(new LeetCode837().new21Game(10, 1, 10));
        System.out.println(new LeetCode837().new21Game(6, 1, 10));
        System.out.println(new LeetCode837().new21Game(21, 17, 10));
        System.out.println(new LeetCode837().new21Game(0, 0, 2));
        System.out.println(new LeetCode837().new21Game(21, 0, 10));
        System.out.println(new LeetCode837().new21Game(5, 0, 10));
    }
}
