package org.implementation.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj20546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int[] arr = new int[15];

        for (int i = 1; i < 15; i++) {
            arr[i] = scanner.nextInt();
        }

        int jun = amount;
        int jun_stock = 0;

        int sung = amount;
        int sung_stock = 0;

        for (int i = 1; i < 15; i++) {
            if (jun >= arr[i]) {
                // 1. 구매한 주식 량
                jun_stock = jun / arr[i];

                // 2. 보유 잔고 -= 구매한 주식 가격 (arr[i] * 매수량)
                jun -= arr[i] * jun_stock;

//                System.out.println("준현 주식 구매일 " +  i);
//                System.out.println("준현 주식 주식 " +  jun_stock);
//                System.out.println("준현 주식 잔고 " +  jun);
            }
        }

        int up = 0;
        int down = 0;

        for (int i = 2; i < 15; i++) {
            if (arr[i] > arr[i - 1]) {
                up++;
                down = 0;
                if (up >= 3 && sung_stock > 0) {
//                    System.out.printf("%d째 날에 전량 매도\n", i);
                    // 1. 전량 매도
                    sung += arr[i] * sung_stock;
                    sung_stock = 0;
                }
            } else if (arr[i] < arr[i - 1]) {
                down++;
                up = 0;
                if (down >= 3 && sung >= arr[i]) {
//                    System.out.printf("%d째 날에 전량 매수\n", i);
                    sung_stock += sung / arr[i];
                    sung -= arr[i] * (sung / arr[i]);
                }
            } else {
                up = 0;
                down = 0;
            }
        }

        jun = jun_stock * arr[14] + jun;
        sung = sung_stock * arr[14] + sung;
        if(jun > sung) {
            System.out.println("BNP");
        } else if(jun < sung) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
