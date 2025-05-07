package org.graph_traversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj14716 {

    static int[] dx = {0,1,0,-1,1,1,-1,-1};
    static int[] dy = {1,0,-1,0,-1,1,1,-1};
    static int graph[][];
    static boolean visited[][];
    static int n, m;
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i < n; i++){
            String[] tokens = br.readLine().split(" ");
            for(int j=0; j < m; j++){
                graph[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){

                if(graph[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    //System.out.println("i : " + i + " j : " + j);
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<8; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(graph[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }

            }
        }
    }
}
