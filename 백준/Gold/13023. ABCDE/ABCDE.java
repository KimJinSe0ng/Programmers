import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //13023
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1); //depth 1부터 시작
            if (arrive) {
                break;
            }
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

    }

    private static void dfs(int now, int depth) {
//        System.out.println("now = " + now + " depth = " + depth);
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) { //현재 노드의 연결 노드 중 방문하지 않은 노드 탐색
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[now] = false; //노드가 연결되어 있을 수 있지만 true 상태이면 방문하지 않는다. 즉, 관계 파악할 수 없음
    }
}
