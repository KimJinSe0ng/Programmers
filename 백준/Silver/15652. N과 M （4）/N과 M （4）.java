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
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        A = new int[M];

        recur(1, 0);
        System.out.println(sb.toString());
    }

    private static void recur(int at, int len) {
        if (len == M) {
            for (int num : A) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
            A[len] = i;
            recur(i, len + 1);
        }
    }
}
