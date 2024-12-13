import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        bfs(X);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        }

    }

    private static void bfs(int start) {
        Queue<City> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new City(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            City now = queue.poll();
            if (now.dist == K) {
                result.add(now.no);
            } else if (now.dist > K) {
                continue;
            }

            for (int next : graph[now.no]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new City(next, now.dist + 1));
                }
            }
        }
    }

    private static class City {
        public int no;
        public int dist;

        public City(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }
    }
}
