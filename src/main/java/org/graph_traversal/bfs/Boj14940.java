package org.graph_traversal.bfs;

import java.io.*;
import java.util.*;

public class Boj14940 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] graph;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        int x = 0;
        int y = 0;

        for(int i=1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j <= m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j] == 2){
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x,y);

        for(int i=1; i <= n; i++){
            for(int j=1; j <= m; j++) {
                if(!visited[i][j] && graph[i][j] != 0){
                    graph[i][j] = -1;
                }
                bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();


    }

    static void bfs(int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        graph[x][y] = 0;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for(int k=0; k < 4; k++){
                int now_x = now[0] + dx[k];
                int now_y = now[1] + dy[k];

                if(now_x > 0 && now_y > 0 && now_x <= n && now_y <= m && !visited[now_x][now_y]){
                    if(graph[now_x][now_y] == 1){
                        graph[now_x][now_y] = graph[now[0]][now[1]] + 1;
                        queue.offer(new int[]{now_x,now_y});
                    }
                }
            }
        }
    }
}
