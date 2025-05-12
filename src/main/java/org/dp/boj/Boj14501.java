package org.dp.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Boj14501 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+2]; //오늘부터 퇴사일까지 벌 수 있는 최대 수입
        int[] t = new int[n+1];
        int[] p = new int[n+1];

        for(int i=1; i<=n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }


        for(int i=n; i>0; i--){

            // i번째 일을 했을 때 퇴사일을 초과
            // 다음날의 수익을 그대로 유지
            if(i+t[i] > n+1) {
                dp[i] = dp[i+1];
            }

            // i번째 일에 일을 할 수 있다.
            else {
                dp[i] = Math.max(dp[i+1], p[i] + dp[i+t[i]]);
                // i번째 일의 보상과 i번째 일을 하고 그만큼 시간이 지났을 때 얻을 수 있는 최대 수익값과 다음날 수익을 비교
            }
        }

        System.out.println(dp[1]);
    }
}
