package org.data_structure.stackQueue;
import java.util.*;
public class Boj2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur = 0;

        Deque<Integer> queue = new ArrayDeque<Integer>();

        for(int i=n; i >0; i--){
            queue.push(i);
        }

        while(queue.size() != 1) {
            queue.pop();
            queue.offerLast(queue.pop());
        }

        System.out.println(queue.peek());
    }
}
