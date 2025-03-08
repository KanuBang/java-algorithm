package org.data_structure.array.슬라이딩윈도우;

import java.util.*;
import java.io.*;
public class Boj11003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st  = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new ArrayDeque<>();

        for(int i=0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(now,i));

            if(mydeque.getFirst().index <= i - l) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
