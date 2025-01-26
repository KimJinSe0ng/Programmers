import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static boolean[] visited;
    static int[] distance;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        graph = new List[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.equals("-1")) break;
                int neighbor = Integer.parseInt(token);
                int weight = Integer.parseInt(st.nextToken());
                graph[v].add(new Node(neighbor, weight));
            }
        }

        int startNode = bfs(1);  // 임의의 노드에서 가장 먼 노드 찾기
        int diameter = bfs(startNode);  // 그 노드에서 가장 먼 거리 찾기
        System.out.println(distance[diameter]);
    }

    private static int bfs(int start) {
        Arrays.fill(visited, false);
        Arrays.fill(distance, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Node neighbor : graph[current]) {
                if (!visited[neighbor.v]) {
                    visited[neighbor.v] = true;
                    distance[neighbor.v] = distance[current] + neighbor.g;
                    queue.add(neighbor.v);

                    if (distance[neighbor.v] > distance[farthestNode]) {
                        farthestNode = neighbor.v;
                    }
                }
            }
        }

        return farthestNode;
    }

    private static class Node {
        public int v;
        public int g;

        public Node(int v, int g) {
            this.v = v;
            this.g = g;
        }
    }
}
