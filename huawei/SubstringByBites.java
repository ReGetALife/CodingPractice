package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SubstringByBites {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        try{
            while (scanner.hasNext()) {
                byte[] bytes = scanner.next().getBytes();
                int n = Integer.parseInt(scanner.next());
                if (n > bytes.length)
                    n = bytes.length;
                if(n<0){
                    n=0;
                }
                String string = new String(bytes, 0, n);
                if (string.length() > 0 && string.charAt(string.length() - 1) == '�')
                    string = string.substring(0, string.length() - 1);
                System.out.println(string);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
