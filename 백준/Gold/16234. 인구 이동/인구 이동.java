import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean isEnd = false;
    static boolean[][] visited;
    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!isEnd) {
            visited = new boolean[N][N];
            boolean moved = false;

            // 1. 연합 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (BFS(new State(i, j, map[i][j]))) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                isEnd = true;
            } else {
                days++; // 인구 이동 수 1 증가
            }
        }

        System.out.println(days);
    }

    private static boolean BFS(State start) {
        Queue<State> union = new LinkedList<>(); // 인구 이동할 수 있는 연합 큐
        Queue<State> updateQueue = new LinkedList<>(); // 업데이트 해야할 큐
        union.add(start);
        updateQueue.add(start);
        visited[start.x][start.y] = true;

        int sum = 0;
        int count = 0;
        boolean moved = false;

        while (!union.isEmpty()) {
            State now = union.poll();
            sum += now.value;
            count++;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                int gap = Math.abs(now.value - map[nx][ny]);

                if (gap >= L && gap <= R) {
                    visited[nx][ny] = true;
                    union.add(new State(nx, ny, map[nx][ny]));
                    updateQueue.add(new State(nx, ny, map[nx][ny]));
                    moved = true;
                }
            }
        }

        // 3. 연합을 이루고 있는 각 칸의 인구수 계산
        int value = sum / count;
        while (!updateQueue.isEmpty()) { // 4. 연합을 이루고 있는 좌표들에 3번의 값으로 갱신
            State update = updateQueue.poll();
            map[update.x][update.y] = value;
        }

        return moved;
    }
}

class State {
    public final int x;
    public final int y;
    public final int value;

    public State(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
