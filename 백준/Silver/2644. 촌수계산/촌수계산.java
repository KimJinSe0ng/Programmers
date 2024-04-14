import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int n, m;
    static int start, target;
    static int call = 0;
    static int count = 0;
    static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        bfs(start, call);
        if (!find) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void bfs(int start, int call) {
        if (find) {
            return;
        }
        call++;
        visited[start] = true;
        for (int v : A[start]) {
            if (!visited[v]) {
                if (v == target) {
                    find = true;
                    count = call;
                    return;
                }
                visited[v] = true;
                bfs(v, call);
            }
        }
    }
}
