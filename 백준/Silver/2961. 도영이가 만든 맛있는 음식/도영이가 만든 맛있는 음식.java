import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ingredient;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ingredient = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 1, 0, 0);
        System.out.println(answer);

    }

    private static void recur(int idx, int sour, int bitter, int used) {
        if (idx == N) {
            if (used == 0) {
                return;
            }
            answer = Math.min(answer, Math.abs(sour - bitter));
            return;
        }

        // 재료를 사용한 경우
        recur(idx + 1, sour * ingredient[idx][0], bitter + ingredient[idx][1], used + 1);

        // 재료를 사용하지 않은 경우
        recur(idx + 1, sour, bitter, used);
    }
}
