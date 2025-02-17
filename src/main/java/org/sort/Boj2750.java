package org.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] nums = new int[n];

        for(int i=0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.nextLine());
        }
        int x = n;

        for(int i=0; i < n; i++){
            int tmp = 0;
            for(int j=0; j < x-1-i; j++){
                if(nums[j] > nums[j+1]) {
                    tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
