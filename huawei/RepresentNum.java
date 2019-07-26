package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class RepresentNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            StringBuilder sb = new StringBuilder(scanner.nextLine());
            boolean flag = true;
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i)>='0'&&sb.charAt(i)<='9'&&flag){
                    sb.insert(i,'*');
                    flag=false;
                }
                if(!flag&&(sb.charAt(i)<'0'||sb.charAt(i)>'9')){
                    sb.insert(i,'*');
                    flag=true;
                }
            }
            System.out.println(sb);
        }
    }
}
