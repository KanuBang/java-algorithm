package org.dp.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912 {

    static int[] arr;
    static int[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1];
        dp[0] = arr[0];
        max = dp[0];

        topdown(n-1);
        System.out.println(max);
    }

    static int topdown(int i){
        if(i == 0){
            return dp[0];
        }

        dp[i] = Math.max(arr[i], topdown(i - 1) + arr[i]);
        max = Math.max(dp[i], max);


        return dp[i];
    }
}
