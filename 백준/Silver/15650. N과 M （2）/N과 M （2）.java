import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> numbers = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        recur(1, 0);

        System.out.println(sb);
    }

    private static void recur(int at, int depth) {
        if (depth == M) {
            for (int num : numbers) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numbers.add(i);
            recur(i, depth + 1);
            numbers.remove(numbers.size() - 1);
            visited[i] = false;
        }
    }

}
