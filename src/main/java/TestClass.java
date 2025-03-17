
import java.util.*;

public class TestClass {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 1; i <= n; i++) {
            int node = sc.nextInt();
            while (true) {
                int edge = sc.nextInt();
                if(edge == -1) break;
                int vertex = sc.nextInt();
                graph[node].add(new Node(edge, vertex));
            }
        }

        // 1. 임의의 노드에서 가장 멀리 떨어져 있는 노드를 찾는다.
        // 2. 그 노드에서 가장 멀리 떨어진 노드가 트리의 지름이다.
        bfs(1);

        // 5. 탐색을 완료 한 후 거리 배열에서 가장 큰 값을 가진 next_start를 찾는다.
        int max = 0;
        int next_start = 0;
        for(int i = 2; i <= n; i++){
            if(distance[i] > max){
                max = distance[i];
                next_start = i;
            }
        }

        // 6. next_start에서 가장 멀린 떨어진 점 까지의 거리가 트리의 지름이다.
        visited = new boolean[n+1];
        distance = new int[n+1];
        bfs(next_start);
        Arrays.sort(distance);
        System.out.println(distance[n]);

    }

    static void bfs(int start) {
        // 1. 시작점을 큐에 넣는다.
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        // 2. 큐가 완전히 빌 때까지 아래의 행외를 반복한다.
        while(!queue.isEmpty()){

        // 3. 큐에서 디큐하고 그 디큐된 점과 인접한 점이 아직 방문 처리가 안 되어 있다면 queue에 넣고 방문 처리한다.
            Integer now = queue.poll();
            for(Node a : graph[now]){
                int edge = a.edge;
                int vertex = a.vertex;

                // 4. 거리 배열을 업데이트 한다.
                if(!visited[edge]){
                    queue.add(edge);
                    visited[edge] = true;
                    distance[edge] = distance[now] + vertex;
                }
            }
        }

    }

    static class Node {
        int edge;

        int vertex;

        public Node(int edge, int vertex) {
            this.edge = edge;
            this.vertex = vertex;
        }
    }

}
