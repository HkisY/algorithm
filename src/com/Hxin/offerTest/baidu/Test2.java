package com.Hxin.offerTest.baidu;

import java.util.*;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/12 20:28
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loopTime = in.nextLine().toCharArray()[0]-'0';
        //方法名
        Set<String> set = new HashSet<>();
        for (int i = 0; i < loopTime; i++) {
            int op = in.nextLine().toCharArray()[0]-'0';
            String s = in.nextLine();
            //创建
            if (op == 1){
                final String[] split = s.split(" ");
                StringBuilder sb = new StringBuilder();
                for (char c : split[1].toCharArray()) {
                    if (c == '('){
                        break;
                    }else {
                        sb.append(c);
                    }
                }
                if (set.contains(sb.toString())){
                    System.out.println("method "+ sb.toString()+ " is already defined.");
                }else {
                    System.out.println("ok.");
                    set.add(sb.toString());
                }
            }else if (op == 2){
                StringBuilder sb = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c=='('){
                        break;
                    }else {
                        sb.append(c);
                    }
                }
                if (set.contains(sb.toString())){
                    System.out.println("ok.");
                }else {
                    System.out.println("cannot find symbol "+ sb.toString());
                }
            }
        }
    }
}
