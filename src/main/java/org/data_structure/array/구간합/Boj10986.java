package org.data_structure.array.구간합;

import java.util.*;
import java.io.*;
public class Boj10986 {
    public static void main(String[] args) throws Exception {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 10^6
        int m = Integer.parseInt(st.nextToken()); // 2 <= m <= 10^3
        long cnt = 0;

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n+1]; // 입력 숫자가 0 <= a_i <= 10^9
        for(int i = 1; i <= n; i++){
            nums[i]= Integer.parseInt(st.nextToken());
        }

        // 2. 합 배열
        long[] sigma = new long[n+1];
        for(int i=1; i <= n; i++){
            sigma[i] = nums[i] + sigma[i-1];
        }


        long[] mods = new long[m];
        for(int i=1; i <= n; i++){
            int mod = (int)(sigma[i] % m);
            mods[mod] += 1;
        }


        for (long mod : mods) {
            if(mod >= 2) {
               cnt += (mod * (mod - 1)) / 2;
               // N=10^6 M=2 일땨
                // 1 1 1 1 ------ 이라고 해보자.
                // mods[1]이 50만이 된다. 50만 *49만9999 이 과정에서 int형의 최대치를 넘어 outof 에러가 발생한다.
            }
        }
        cnt += mods[0];

        System.out.println(cnt);
    }
}
