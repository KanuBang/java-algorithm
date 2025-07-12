package org.sort.selection;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        int[] nums = new int[string.length()];

        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(string.substring(i,i+1));
        }

        for(int i = 0; i < n; i++){
            int max = i;
            for(int j = i+1; j < n; j++){
                if(nums[j] > nums[max]){
                    max = j;
                }
            }

            if(nums[i] < nums[max]){
                int tmp = nums[i];
                nums[i] = nums[max];
                nums[max] = tmp;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(nums[i]);
        }


    }
}
