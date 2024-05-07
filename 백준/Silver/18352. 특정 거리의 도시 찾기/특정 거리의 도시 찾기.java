import java.util.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] A;
    static int[] visited = new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        A = new ArrayList[N + 1];
//        visited = new int[N + 1];
//        Arrays.fill(visited, -1);
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            //A[e].add(s);
        }

        bfs(X);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : A[now]) {
                if (visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);
    }

}