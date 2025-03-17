package org.graph_traversal.bfs;
import java.util.*;
import java.io.*;
public class Boj1167 {
    static boolean visited[];
    static int[] distance;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i < n; i++) {
            int s = sc.nextInt();
            while(true){
                int e = sc.nextInt();
                if( e == -1) break;
                int v = sc.nextInt();
                graph[s].add(new Node(e,v));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];

        bfs(1);
        int max = 1;

        for(int i =2; i <= n; i++) {
            if(distance[max] < distance[i]){
                max = i;
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);

    }

    private static void bfs(int index) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(Node x : graph[now_node]) {
                int e = x.e;
                int value = x.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] += distance[now_node] + value;
                }
            }
        }
    }

    static class Node {
        int e;
        int value;
        public Node(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
