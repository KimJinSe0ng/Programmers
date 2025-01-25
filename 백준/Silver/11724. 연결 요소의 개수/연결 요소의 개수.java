import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int v = 1; v <= N; v++) {
            if (!visited[v]) {
                dfs(v);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
