package org.sort.comparator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;

public class Boj1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        MyString[] str = new MyString[n];

        for(int i = 0 ; i < n; i++){
            str[i] = new MyString(sc.next());
        }

        Arrays.sort(str);

        System.out.println(str[0].s);
        for(int i = 1 ; i < n; i++){
            if(str[i].s.equals(str[i-1].s)){
                continue;
            }
            System.out.println(str[i].s);
        }
    }

    static class MyString implements Comparable<MyString> {
        private String s;

        public MyString(String s) {
            super();
            this.s = s;
        }

        @Override
        public int compareTo(MyString ms) {

            if(this.s.length() != ms.s.length()){
                return this.s.length() - ms.s.length();
            } else{
                return this.s.compareTo(ms.s);
            }


        }
    }
}
