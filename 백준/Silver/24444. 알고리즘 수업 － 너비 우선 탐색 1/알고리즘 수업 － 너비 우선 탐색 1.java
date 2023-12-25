import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int[] order;
    static int count = 1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[e].add(s);
            A[s].add(e);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(A[i]);
        }
        order = new int[N + 1];
        bfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        order[v] = count++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
//            visited[count] = now;
//            count++;
            for (int newNode : A[now]) {
                if (!visited[newNode]) {
                    queue.add(newNode);
                    visited[newNode] = true;
                    order[newNode] = count++;
                }
            }
        }
    }
}