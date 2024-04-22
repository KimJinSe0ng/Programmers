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
    static boolean[][] visited;
    static boolean isDivided;
    static int year;

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

        int count = 0;
        while (!isDivided) {
            count = bfsCount();
            if (count >= 2) {
                isDivided = true;
                break;
            }
            if (count == 0) {
                year = 0;
                break;
            }
            bfs(); //빙산 녹이기
            year++;
        }
        System.out.println(year);
    }

    private static void bfs() { //빙산 녹이기
//        System.out.println("빙산 녹이기");
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];

        //전체 좌표 탐색 후 빙산이 있는 위치 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        sea++;
                    }
                }
            }

            if (map[now[0]][now[1]] - sea < 0) {
                map[now[0]][now[1]] = 0;
            } else {
                map[now[0]][now[1]] -= sea;
            }

        }
    }

    private static int bfsCount() {
//        System.out.println("빙산 그룹 개수 세기");
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];
        //전체 좌표 탐색 후 빙산이 있는 위치 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                                if (map[nx][ny] != 0 && !visited[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                    count++;
//                    System.out.println("count = " + count);
                }
            }
        }
        return count;
    }
}
