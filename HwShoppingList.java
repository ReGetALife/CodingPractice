package tk.solidays.algorithm;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class HwShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int money = scanner.nextInt();//总共m块钱
            int n = scanner.nextInt();//物品数量
            Thing[] things = new Thing[n];
            for (int i = 0; i < n; i++) {
                things[i] = new Thing();//下标i中存的是编号为i+1的物品
                things[i].value = scanner.nextInt();
                things[i].priority = scanner.nextInt() * things[i].value;
                things[i].q = scanner.nextInt();
            }
            //01背包问题优化空间后成为一维数组，加上一个维度来存储当前放入了哪些物品，于是又变成二维dp[money][0]相当于原来的一维
            int[][] dp = new int[1 + money][1 + n];
            for (int i = 0; i < n; i++) {
                for (int j = money; j >= 0; j--) {
                    //为附，且主没有买
                    if (things[i].q != 0 && 1 != dp[j - things[i].value][things[i].q]) {
                        if ((things[i].value + things[things[i].q - 1].value) <= j) {
                            int temp = dp[j - things[i].value - things[things[i].q - 1].value][0] + things[i].priority + things[things[i].q - 1].priority;
                            if (temp > dp[j][0]) {
                                dp[j][0] = temp;
                                dp[j][i + 1] = 1;
                                dp[j][things[i].q] = 1;
                            }
                        }
                    }
                    //为主，或为附但主买了
                    else {
                        if (things[i].value <= j) {
                            int temp = dp[j - things[i].value][0] + things[i].priority;
                            if (temp > dp[j][0]) {
                                dp[j][0] = temp;
                                dp[j][i + 1] = 1;
                            }
                        }
                    }
                }
            }
            System.out.println(dp[money - 1][0]);
        }
    }
}

class Thing {
    int value;
    int priority;
    int q;
}
