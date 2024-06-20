import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int safeArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(safeArea);
    }

    private static void countSafeArae() { //바이러스 감염 및 안전영역 세기
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<State> q = new LinkedList<>();

        for (int i = 0; i < N; i++) { //큐에 모든 바이러스 추가
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) {
                    q.add(new State(i, j));
                }
            }
        }

        while (!q.isEmpty()) { //바이러스 감염
            State now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.add(new State(nx, ny));
                }
            }
        }

        int area = 0; //안전영역 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    area++;
                }
            }
        }

        safeArea = Math.max(safeArea, area);
    }

    private static void DFS(int walls) {
        if (walls == 3) { //벽을 3개 세우면 바이러스 감염 및 안전영역 세기
            countSafeArae();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(walls + 1);
                    map[i][j] = 0; //세웠던 벽을 다시 허뭄
                }
            }
        }
    }

    private static class State {
        public final int x;
        public final int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
