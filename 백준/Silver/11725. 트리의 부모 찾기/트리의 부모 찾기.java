import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        par = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(par[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                par[next] = node;
                dfs(next);
            }
        }
    }
}
