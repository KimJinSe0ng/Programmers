import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int K;
    static List<Node>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];

        Arrays.fill(dist, INF);
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] != INF) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.w, o2.w);
        });
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int currentV = now.v;
            int currentW = now.w;

            if (currentW > dist[currentV]) {
                continue;
            }

            for (Node next : graph[currentV]) {
                if (dist[next.v] > dist[currentV] + next.w) {
                    dist[next.v] = dist[currentV] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    private static class Node {
        public int v;
        public int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
