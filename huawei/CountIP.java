package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类
 *
 * A类地址1.0.0.0~126.255.255.255;
 *
 * B类地址128.0.0.0~191.255.255.255;
 *
 * C类地址192.0.0.0~223.255.255.255;
 *
 * D类地址224.0.0.0~239.255.255.255；
 *
 * E类地址240.0.0.0~255.255.255.255
 *
 *
 * 私网IP范围是：
 *
 * 10.0.0.0～10.255.255.255
 *
 * 172.16.0.0～172.31.255.255
 *
 * 192.168.0.0～192.168.255.255
 *
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 *
 * 输入描述:
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述:
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * 示例1
 * 输入
 * 复制
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 * 输出
 * 复制
 * 1 0 1 0 0 2 1
 */
public class CountIP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int[] ans = new int[7];
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            try {
                String[] ipAndMask = string.split("~");
                String[] ipStr = ipAndMask[0].split("\\.");
                String[] maskStr = ipAndMask[1].split("\\.");
                //检查是否全在0~255之间
                for (int i = 0; i < 4; i++) {
                    int temp = Integer.parseInt(ipStr[i]);
                    if (temp < 0 || temp > 255)
                        throw new Exception();
                }
                for (int i = 0; i < 4; i++) {
                    int temp = Integer.parseInt(maskStr[i]);
                    if (temp < 0 || temp > 255)
                        throw new Exception("wrong range");
                }
                //将掩码放到32位的int中
                int mask = 0;
                for (int i = 0; i < 4; i++) {
                    mask = (mask << 8) | Integer.parseInt(maskStr[i]);
                }
                //判断掩码是否合法
                int one = 1;
                mask = ~mask;
                if (mask == 0)//全1掩码非法
                    throw new Exception("wrong mask");
                while (mask != 0) {
                    if ((mask & one) == 1) {
                        mask = mask >> 1;
                    } else
                        throw new Exception("wrong mask");
                }
                int ip1 = Integer.parseInt(ipStr[0]);
                if (ip1 >= 1 && ip1 <= 126) {
                    ans[0]++;
                    if (ip1 == 10) {
                        ans[6]++;
                    }
                    continue;
                } else if (ip1 >= 128 && ip1 <= 191) {
                    ans[1]++;
                    if (ip1 == 172 && (Integer.parseInt(ipStr[1]) >= 16 && Integer.parseInt(ipStr[1]) <= 31)) {
                        ans[6]++;
                    }
                    continue;
                } else if (ip1 >= 192 && ip1 <= 223) {
                    if (ip1 == 192 && Integer.parseInt(ipStr[1]) == 168) {
                        ans[6]++;
                    }
                    ans[2]++;
                    continue;
                } else if (ip1 >= 224 && ip1 <= 239) {
                    ans[3]++;
                    continue;
                } else if (ip1 >= 240) {
                    ans[4]++;
                    continue;
                }
                //throw new Exception("wrong ip");//合法但不属于以上5类
            } catch (Exception exc) {
                ans[5]++;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if (i != ans.length - 1)
                System.out.print(" ");
        }
    }
}
