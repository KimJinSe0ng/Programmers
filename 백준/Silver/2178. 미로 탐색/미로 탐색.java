import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String a = scan.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = a.charAt(j) - '0';
            }
        }
        bfs();
        System.out.print(map[N - 1][M - 1]);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        int x = 0;
        int y = 0;
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int xy[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = xy[0] + dx[i];
                y = xy[1] + dy[i];
                if (x < 0 || y < 0 || x > N || y > M || visited[x][y] == true || map[x][y] == 0) {
                    continue;
                } else {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                    map[x][y] = map[xy[0]][xy[1]] + 1;
                }
            }
        }


    }
}
