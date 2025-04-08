package org.graph_traversal.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2468 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int h;
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        int max_val = 0;
        int count = 0;
        int answer = 0;
        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max_val = Math.max(max_val, graph[i][j]);
            }
        }

        for(int h=0; h<=max_val; h++){
            visited = new boolean[n][n];
            count = 0;
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                    // 1. 물에 잠기지 않았고 아직 방문하지 않은 점이 BFS의 탐색 지점이다.
                    if(graph[i][j] > h && !visited[i][j]){
                        count++;
                        bfs(i,j,h);

                    }
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int j, int h){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < n && y < n) {
                    if(!visited[x][y] && graph[x][y] > h) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
