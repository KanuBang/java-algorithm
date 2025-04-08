package org.graph_traversal.bfs;
import java.io.*;
import java.util.*;
public class 미로찾기BFS {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int graph[][];
    static boolean visited[][];
    static int n, m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j < m; j++){
                graph[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        bfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }

    public static void bfs(int i, int j){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < n && y < m) {
                    if(graph[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        graph[x][y] = graph[now[0]][now[1]]+1;
                        System.out.println(graph[x][y]);
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
