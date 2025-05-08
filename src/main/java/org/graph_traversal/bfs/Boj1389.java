package org.graph_traversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1389 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for(int i=1; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        for(int i=1; i < n+1; i++){
            Collections.sort(graph[i]);
        }

        int min = 9999999;
        int answer = 0;
        for(int i=1; i < n+1; i++){
            distance = new int[n+1];
            visited = new boolean[n+1];
            bfs(i);

            int sum = Arrays.stream(distance).sum();
            if(sum < min){
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int v){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visited[v] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            Integer front = queue.poll();
            for (Integer node : graph[front]) {
                if(!visited[node]){
                    visited[node] = true;
                    queue.offer(node);
                    distance[node] = distance[front] + 1;
                }
            }
        }
    }
}
