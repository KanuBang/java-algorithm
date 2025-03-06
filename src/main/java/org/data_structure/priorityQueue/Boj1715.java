package org.data_structure.priorityQueue;

import java.io.*;
import java.util.*;

public class Boj1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int pairSum = 0;
        int n1 =0;
        int n2=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        if(n == 1) {
            System.out.println(0);
            return;
        }

        while(pq.size() != 1) {
            n1 = pq.poll();
            n2 = pq.poll();
            pairSum = n1 + n2;
            sum += pairSum;
            pq.add(pairSum);
        }
        System.out.println(sum);
    }
}
