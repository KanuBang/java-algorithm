package org.data_structure;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Boj1546 {
    public static void main(String[] args) {
        // 1. 입력 받기 (double)
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();

        int[] nums = new int[cnt];
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        // 2. 가장 큰 값을 구한다
        int max = Arrays.stream(nums).max().getAsInt();

        // 3. 모든 점수의 합 / 가장 큰 값 / 과목의 개수 * 100
        double result = (double)Arrays.stream(nums).sum() / max / cnt * 100;
        System.out.println(result);
    }
}

/*
1. 입력
첫째 줄: 과목의 개수 N (N <= 1000)
두째 줄: 현재 성적 (0 <= 성적 <= 100, 적어도 1개의 값은 0보다 크다.)

2. 히든 테케
{(40/80 * 100) + (80/80 * 100) + (60/80 * 100)} / 3 = (40+80+60) / 80 / 3 * 100 = 180 / 80 / 3 * 100
= 3/4*100 = 75

입력이 1개이면? -> 그대로 리턴
모두 0이면 -> 입력값 조건
소수점 발생 -> double로 입력을 받자.

3. 슈도코드
// 1. 입력 받기 (double)
// 2. 가장 큰 값을 구한다
// 3. 모든 점수의 합 / 가장 큰 값 / 과목의 개수 * 100

 */