import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static boolean isExist = false;
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

        for (int i = 0; i < N; i++) { //0부터 시작하여 N까지 찾아보기
            DFS(i, 0);
            if (isExist) {
                break;
            }
        }

        if (isExist) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void DFS(int now, int relationship) {
        if (relationship == 4 || isExist) {
            isExist = true;
            return;
        }
        visited[now] = true;

        for (int next : A[now]) {
            if (!visited[next]) {
                DFS(next, relationship + 1);
            }
        }
        visited[now] = false; //노드가 연결되어 있을 수 있지만 true 상태이면 방문하지 않는다. 즉, 관계 파악할 수 없음
    }
}
