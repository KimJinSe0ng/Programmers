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

    static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new String[L][W];

        for (int i = 0; i < L; i++) {
            String line = br.readLine();
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
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[L][W];
        visited[x][y] = true;
        queue.add(new Node(x, y, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= L || ny >= W) {
                    continue;
                }
                if (map[nx][ny].equals("W")) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int newDist = current.dist + 1;
                    maxDist = Math.max(maxDist, newDist);
                    queue.add(new Node(nx, ny, newDist));
                }
            }
        }
    }
}
