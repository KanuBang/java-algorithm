package org.data_structure.array.투포인터;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Boj1940 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        // 1.입력
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        String nums = sc.nextLine();
        StringTokenizer st = new StringTokenizer(nums);
        int[] arr = new int[n];
        for(int i = 0;  i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 정렬을 한다.
        Arrays.sort(arr);

        int start = 0;
        int end = 1;
        int cnt = 0;
        int sum = 0;
        // n = 6 , 마지막 인덱스5
        while( end < n && start < n ){
            sum = arr[start] + arr[end];
            if(sum != m){
                end++;
            } else {
                cnt++;
                start++;
                end = start+1;
            }

            if(end == n) {
                start++;
                end = start + 1;
            }
        }
        System.out.println(cnt);
    }
}
