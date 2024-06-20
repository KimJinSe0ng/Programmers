import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, X;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static boolean isFind = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
//            A[e].add(s); //단방향 그래프
        }

        BFS(X);

        if (!isFind) {
            System.out.println(-1);
        }
    }

    private static void BFS(int start) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(start, 0));
        visited[start] = true;
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            State now = queue.poll();

            if (now.depth == K) {
                isFind = true;
                result.add(now.node);
            }

            for (int next : A[now.node]) {
                if (!visited[next]) {
                    queue.add(new State(next, now.depth + 1));
                    visited[next] = true;
                }
            }
        }

        if (isFind) {
            result.sort(null);
            for (int node : result) {
                System.out.println(node);
            }
        }
    }

    private static class State {
        public final int node;
        public final int depth;

        public State(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
