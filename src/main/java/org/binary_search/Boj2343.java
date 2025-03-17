package org.binary_search;

import java.util.Scanner;

public class Boj2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int start = 0;
        int end = 0;

        for(int i=0; i < n; i++) {
            a[i] = sc.nextInt();
            if(start < a[i]) start = a[i];
            end = end + a[i];
        }

        while(start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for(int i=0; i < n; i++) {
                if(sum + a[i] > middle) {
                    count++;
                    sum = 0;
                }

                sum += a[i];
            }

            if(sum != 0) {
                count++;
            }

            // 블루레이 3개만 가능한데 4개라는 뜻은 용량이 부족하다는 뜻이다.
            if(count > m) {
                start = middle + 1;
            }
            // 블루레이 3개로 가능한데 2개로도 가능하다면 용량을 너무 크게 잡은 거다.
            else {
                end = middle - 1;
            }

        }
        System.out.println(start);
    }
}
