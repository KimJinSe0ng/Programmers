import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visited;
    static int[] A;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        A = new int[m + 1];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int value : A) {
                if (value != 0) {
                    sb.append(value).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                A[depth] = i;
                dfs(depth + 1);
//                visited[i] = false;
                for (int j = i + 1; j <= n; j++) {
                    visited[j] = false;
                }
            }
        }
    }
}
