import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, W;
    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int maxDist = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new String[L][W];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.substring(j, j + 1);
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j].equals("L")) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxDist);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[L][W];
        int[][] dist = new int[L][W];
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= L || ny >= W) {
                    continue;
                }
                if (map[nx][ny].equals("W")) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    maxDist = Math.max(maxDist, dist[nx][ny]);
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
