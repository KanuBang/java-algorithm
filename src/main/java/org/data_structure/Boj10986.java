package org.data_structure;

import java.util.*;
import java.io.*;
public class Boj10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n+1];
        for(int i = 1; i <= n; i++){
            nums[i]= Integer.parseInt(st.nextToken());
        }

        int[] sigma = new int[n+1];
        for(int i=1; i <= n; i++){
            sigma[i] = nums[i] + sigma[i-1];
        }


        int candidate = 1; // 인덱스 0번째 0값 포함 (3으로 나누어 떨어짐)
        for(int i=1; i <= n; i++){
            if(nums[i] % m == 0){
                cnt += 1;
            }
            if(sigma[i] % m == 0) {
                candidate += 1;
            }
        }

        cnt += (candidate*(candidate-1)) / 2;

        System.out.println(cnt);
    }
}
