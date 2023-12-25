import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
//    static boolean visited[];
    static int[] checked;
    static int cnt = 1;
    static StringBuilder sb = new StringBuilder(); // 방문 순서를 저장하기 위한 StringBuilder
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점
        int M = Integer.parseInt(st.nextToken()); //간선
        int R = Integer.parseInt(st.nextToken()); //시작점
        A = new ArrayList[N + 1];
//        visited = new boolean[N + 1];
        checked = new int[N + 1];
        for (int i = 1; i < N + 1; i++) { //인접리스트 초기화
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) { //정점 추가
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i <= N; i++) { //번호가 작은 것을 먼저 방문하기 위해 정렬하기
            Collections.sort(A[i]);
        }
        dfs(R);
        // 방문 순서 출력
//        System.out.println(sb.toString());
        for (int i = 1; i <= N; i++) {
            sb.append(checked[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int node) {
        checked[node] = cnt++;

        for (int v : A[node]) {
            if (checked[v] == 0) {
                dfs(v);
            }
        }
    }
//    static void dfs(int node) {
//        if (visited[node]) {
//            return;
//        }
//        sb.append(node).append("\n"); // 방문한 순서를 StringBuilder에 추가
//        visited[node] = true;
//        boolean hasVisited = false; // 시작 정점에서 방문할 수 있는 정점이 있는지 확인하는 플래그
//
//        for (int v : A[node]) {
//            if (!visited[v]) {
//                hasVisited = true; // 방문할 수 있는 정점이 있음을 표시
//                dfs(v);
//            }
//        }
//
//        if (!hasVisited) {
//            sb.append("0"); // 방문할 수 있는 정점이 없으면 0을 추가
//        }
//    }
}
