import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        dfs(1, 0);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int node, int prev) {
        for (int next : tree[node]) {
            if (next == prev) { // 역주행 제한
                continue;
            }
            parent[next] = node; 
            dfs(next, node); 
        }
    }
}
