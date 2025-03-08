package org.data_structure.array.슬라이딩윈도우;
import java.util.*;
import java.io.*;
public class Boj2559 {
    public static void main(String[] args) throws Exception{

        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for(int i=0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 초기 sum, max
        int sum = 0;
        int max = 0;
        for(int i=0; i < k; i++){
            sum += nums[i];
            max = sum;
        }

        for(int i=k; i < n; i++) {
            sum += nums[i]; // sum + nums[2] [3]
            sum -= nums[i-k]; // sum - nums[0] [1

            if(sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}

/*

. N은 2 이상 100,000
. 1 <= k <= N

3 -2 -4 -9 0 3 7 13 8 -3


O(N)
 */