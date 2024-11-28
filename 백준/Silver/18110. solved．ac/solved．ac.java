import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        level = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            level[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(level);

        int except = (int) Math.round(N * 0.15);
        int sum = 0;

        for (int i = 1 + except; i <= N - except; i++) {
            sum += level[i];
        }
        double avg = (double) sum / (N - except * 2);
        System.out.println((int) Math.round(avg));
    }
}
