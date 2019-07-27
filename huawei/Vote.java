package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 每行输出候选人的名字和得票数量。
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * A B C D
 * 8
 * A B C D E F G H
 * 输出
 * 复制
 * A : 1
 * B : 1
 * C : 1
 * D : 1
 * Invalid : 4
 */
public class Vote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] candidates = new String[n];
            int[] rank = new int[n + 1];
            for (int i = 0; i < n; i++) {
                candidates[i] = scanner.next();
            }
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                String s = scanner.next();
                boolean flag = true;
                for (int j = 0; j < candidates.length; j++) {
                    if (s.equals(candidates[j])) {
                        rank[j]++;
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    rank[n]++;
            }
            for (int i = 0; i < n; i++) {
                System.out.println(candidates[i] + " : " + rank[i]);
            }
            System.out.println("Invalid : " + rank[n]);
        }
    }
}
