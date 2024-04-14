import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        network = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            network[s].add(e);
            network[e].add(s);
        }

        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int v : network[node]) {
            if (!visited[v]) {
                visited[v] = true;
                count++;
                dfs(v);
            }
        }
    }
}
