package org.dp.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2156 {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n+1];

        int[] arr = new int[n+1];
        for(int i=1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i <= n; i++){
            if(i == 1){
                dp[1] = arr[1];
            } else if (i == 2) {
                dp[2] = dp[1] + arr[2];
            } else {
                dp[i] = Math.max(dp[i-1],Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
            }
        }

        System.out.println(dp[n]);
    }
}
