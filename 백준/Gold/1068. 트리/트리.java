import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static int remove;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        parent = new int[N];
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                root = i;
            } else {
                graph[parent[i]].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        if (remove == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(leafCount);
    }

    private static void dfs(int node) {
        if (node == remove) return;
        visited[node] = true;

        boolean isLeaf = true;
        for (int next : graph[node]) {
            if (!visited[next] && next != remove) {
                isLeaf = false;
                dfs(next);
            }
        }

        if (isLeaf) leafCount++;
    }

}
