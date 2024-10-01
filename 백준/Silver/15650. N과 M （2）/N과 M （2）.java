import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static boolean[] visited;
    static List<Integer> A = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        visited = new boolean[N + 1];

        recur(0);
        System.out.println(sb.toString());
    }

    private static void recur(int len) {
        if (len == M) {
            for (Integer num : A) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            A.add(i);
            recur(len + 1);
            A.remove(A.size() - 1);
            for (int j = i + 1; j <= N; j++) {
                visited[j] = false;
            }
        }
    }
}
