package org.data_structure;

import java.util.Scanner;

public class Boj11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        String sNum = sc.nextLine();
        char[] charArray = sNum.toCharArray();
        int sum = 0;

        for(int i = 0; i < cnt; i++){
            sum += charArray[i] - '0';
        }

        System.out.println(sum);
    }
}

/*
1. 입력을 받는다
2. 문자를 숫자로 변환한 다음 sum에 더한다.
 */
