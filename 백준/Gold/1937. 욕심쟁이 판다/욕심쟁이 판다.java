import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxDays = Math.max(maxDays, recur(i, j));
            }
        }

        System.out.println(maxDays + 1);

    }

    private static int recur(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], recur(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }
}
