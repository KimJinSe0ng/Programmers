import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean visited[];
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        //주어진 모든 노드에 DFS를 수행하고 재귀의 깊이가 5이상(5개의 노드가 재귀 형태로 연결)이면 1, 아니면 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n];
        visited = new boolean[n];
        arrive = false;
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 0; i < n; i++) {
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

    static void dfs(int now, int depth) {
        if (depth == 5 || arrive) { //depth가 5가 되면 종료
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                dfs(i, depth + 1); //재귀 호출이 될 때마다 depth를 1씩 증가
            }
        }
        visited[now] = false;
    }
}