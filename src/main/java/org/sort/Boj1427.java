package org.sort;

import java.io.*;
import java.util.*;

/*

2143

2 | 143 - > 2 4 -> 4123

41 | 23  -> 1 3 -> 4321
 */
public class Boj1427 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int[] a = new int[str.length()];

        for(int i=0; i < a.length; i++) {
            a[i] = Integer.parseInt(str.substring(i,i+1));
        }

        int max = 0;
        /*
        1. 정해진 부분에서 최댓값을 찾는다.
        2. 가장 앞에 있는 것과 교환한다.
        3. 가장 앞을 나타내는 인덱스를 +1 증가시킨다.
         */
        for(int i=0; i < a.length; i++){
            max = i;
            for(int j=i+1; j < a.length; j++){
                if(a[j] > a[max]){
                    max = j;
                }
            }
            int tmp = a[i];
            a[i] = a[max];
            a[max] = tmp;
        }

        for(int n: a){
            System.out.printf("%d",n);
        }
    }
}
