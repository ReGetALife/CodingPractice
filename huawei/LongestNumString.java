package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestNumString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            List<Integer> list = new ArrayList<>();
            boolean flag=false;
            int maxLen=0;
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c>='0'&&c<='9'){
                    count++;
                    if(count>maxLen){
                        maxLen=count;
                        list.clear();
                        list.add(i);
                    }
                    else if(count==maxLen){
                        list.add(i);
                    }
                }
                else
                    count=0;
            }
            for(Integer i:list){
                System.out.print(s.substring(i+1-maxLen,i+1)+",");
            }
            System.out.println(maxLen);
        }
    }
}
