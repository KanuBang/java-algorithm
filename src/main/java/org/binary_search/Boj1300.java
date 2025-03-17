package org.binary_search;

import java.util.Scanner;

public class Boj1300 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 3
        int k = sc.nextInt(); // 7
        long start = 1;
        long end = k;
        long ans = 0;

        // 이분 탐색 수행
        while(start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;

            // 중간 값보다 작은 수는 몇 개인지 계산
            for(int i=1; i <= n; i++) {

            }
        }



    }
}
