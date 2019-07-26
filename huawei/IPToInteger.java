package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 示例1
 * 输入
 * 复制
 * 10.0.3.193
 * 167969729
 * 输出
 * 复制
 * 167773121
 * 10.3.3.193
 */
public class IPToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String[] ipStr = ip.split("\\.");
            long ipL = 0;
            for (int i = 0; i < 4; i++) {
                ipL = (ipL << 8) | Integer.parseInt(ipStr[i]);
            }
            System.out.println(ipL);
            Long integer = Long.parseLong(scanner.nextLine());
            Long helper = 255L;//0b11111111
            for (int i = 3; i >=0; i--) {
                ipStr[i]=Long.valueOf(integer&helper).toString();
                integer>>=8;
            }
            System.out.println(String.join(".",ipStr));
        }
    }
}
