package org.data_structure.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> myPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(myPq.isEmpty()) System.out.println("0");
                else System.out.println(myPq.poll());
            } else {
                myPq.add(request);
            }
        }
    }
}
