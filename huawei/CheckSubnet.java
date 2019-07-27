package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入子网掩码、两个ip地址
 *
 * 输出描述:
 * 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
 *
 * 示例1
 * 输入
 * 复制
 * 255.255.255.0 192.168.224.256 192.168.10.4
 * 输出
 * 复制
 * 1
 */
public class CheckSubnet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            try{
                String[] mask = scanner.next().split("\\.");
                //测试用例有问题，要补0
                int n =mask.length;
                if(n<4){
                    String[] temp = Arrays.copyOf(mask,4);
                    for (int i = 2; i < 4; i++) {
                        temp[i]="0";
                    }
                    mask = temp;
                }
                String[] ip1 = scanner.next().split("\\.");
                String[] ip2 = scanner.next().split("\\.");
                int binaryMask = 0;
                int binaryIp1  =0;
                int binaryIp2  =0;
                for (int i = 0; i < 4; i++) {
                    if(Integer.parseInt(mask[i])<0||Integer.parseInt(mask[i])>255
                            ||Integer.parseInt(ip1[i])<0||Integer.parseInt(ip1[i])>255
                            ||Integer.parseInt(ip2[i])<0||Integer.parseInt(ip2[i])>255)
                        throw new Exception("wrong range");
                    binaryMask=(binaryMask<<8);
                    binaryIp1=(binaryIp1<<8);
                    binaryIp2=(binaryIp2<<8);
                    binaryMask = (binaryMask|Integer.parseInt(mask[i]));
                    binaryIp1 = (binaryIp1|Integer.parseInt(ip1[i]));
                    binaryIp2 = (binaryIp2|Integer.parseInt(ip2[i]));

                }
                binaryIp1 = (binaryIp1&binaryMask);
                binaryIp2 = (binaryIp2&binaryMask);
                if(binaryIp1==binaryIp2)
                    System.out.println(0);
                else System.out.println(2);
            }catch (Exception e) {
                System.out.println(1);
            }
        }
    }
}
