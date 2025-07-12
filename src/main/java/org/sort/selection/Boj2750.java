package org.sort.selection;

import java.util.Scanner;

public class Boj2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] a = new int[str.length()];

        for(int i = 0; i < str.length(); i++){
            a[i] = Integer.parseInt(str.substring(i,i+1));
        }


        for(int i = 0; i < a.length; i++){

            int max = i;

            // select
            for(int j = i+1; j < a.length; j++){
                if(a[j] > a[max]){
                    max = j;
                }
            }

            if(a[max] > a[i]){
                int tmp = a[i];
                a[i] = a[max];
                a[max] = tmp;
            }
        }

        for(int x : a){
            System.out.print(x);
        }
    }
}
