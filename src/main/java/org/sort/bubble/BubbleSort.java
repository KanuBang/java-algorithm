package org.sort.bubble;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int tmp = 0;
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        for(int j = n-1; j > 0; j--){
            for(int k = 0; k < j; k++){
                if(nums[k] > nums[k+1]){
                    tmp = nums[k+1];
                    nums[k+1] = nums[k];
                    nums[k] = tmp;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.printf("%d ",nums[i]);
        }
    }


}
