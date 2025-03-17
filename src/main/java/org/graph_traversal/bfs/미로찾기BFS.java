package org.graph_traversal.bfs;
import java.io.*;
import java.util.*;
public class 미로찾기BFS {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(input.substring(j,j+1));
            }
        }
        bfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }

    static void bfs(int i, int j){
        Deque<int[]> queue = new ArrayDeque<>();
        // 1. 시작점을 큐에 넣고 방문 처리를 한다.
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        // 2. 큐에서 디큐하고 그 점과 인접한 점을 큐에 삽입하고 방문 처리한다.
        // 3. 과정을 큐가 빌 때까지 반복한다.
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(graph[x][y] != 0 && !visited[x][y]){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                        graph[x][y] = graph[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
