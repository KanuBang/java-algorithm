package org.data_structure.array.투포인터;
import java.util.*;
import java.io.*;
public class Boj1253 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for(int i=0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int cnt = 0;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            long find = nums[i];
            int s = 0; //start
            int e = n-1; //end

            while(s < e) {
                sum = nums[s] + nums[e];
                if(sum == find) {
                    if(s != i && e != i) {
                        cnt++;
                        break;
                    } else if(s == i) {
                        s++;
                    } else if(e == i) {
                        e--;
                    }
                } else if(sum < find) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        System.out.println(cnt);
    }
}
