package org.data_structure.array.투포인터;
import java.util.*;
public class Boj2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];

        for(int i=1; i <=n; i++){
            nums[i] = i;
        }

        int cnt = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(!(end == n)) {
            if (sum < n) {
                end++;
                sum += nums[end];
            } else if (sum > n) {
                sum -= nums[start];
                start++;
            } else if(sum == n){
                cnt++;
                end++;
                sum += nums[end];
            }

        }
        System.out.println(cnt);

    }
}
