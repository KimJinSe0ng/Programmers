import java.io.*;
import java.util.*;

public class Main {
    static int computers, networks;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        computers = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        networks = Integer.parseInt(st.nextToken());
        graph = new List[computers + 1];
        visited = new boolean[computers + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < networks; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

//        dfs(1);
        bfs(1);
        System.out.println(answer);
    }

    private static void dfs(int S) {
        visited[S] = true;

        for (int next : graph[S]) {
            if (!visited[next]) {
                answer++;
                dfs(next);
            }
        }
    }

    private static void bfs(int S) {
        Queue<Integer> queue = new LinkedList<>();
        visited[S] = true;
        queue.add(S);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer++;
                    queue.add(next);
                }
            }
        }
    }
}
