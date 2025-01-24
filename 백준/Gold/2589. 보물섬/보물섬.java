import java.io.*;
import java.util.*;

public class Main {
    static int Y, X;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxDistance = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new char[Y][X];

        for (int i = 0; i < Y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (map[y][x] == 'L') {
                    bfs(y, x);
                }
            }
        }

        System.out.println(maxDistance);
    }

    private static void bfs(int sY, int sX) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[Y][X];
        int[][] dist = new int[Y][X];

        queue.add(new int[]{sY, sX});
        visited[sY][sX] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (0 <= ny && ny < Y && 0 <= nx && nx < X) {
                    if (!visited[ny][nx] && map[ny][nx] == 'L') {
                        queue.add(new int[]{ny, nx});
                        dist[ny][nx] = dist[now[0]][now[1]] + 1;
                        visited[ny][nx] = true;
                        maxDistance = Math.max(maxDistance, dist[ny][nx]);
                    }
                }
            }
        }
    }
}
