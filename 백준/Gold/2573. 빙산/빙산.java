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
    static int answer = 0;
    static int part; //분리된 빙산의 개수
    public static void main(String[] args) throws IOException {
        //입력받기
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
//        System.out.println("---before---");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        //나눠져 있는지 확인할 때 까지
        while (true) {
            if (bfsCnt(map) == 0) {
                answer = 0;
                break;
            }
            if (bfsCnt(map) >= 2) {
                break;
            }
            bfs(); //빙하 녹이기
            answer++;
        }
        System.out.println(answer);
        //탐색이 끝나고, 근처에 바다가 있는 개수만큼 감소를 시킴
    }

    /**
     * 위와 같이 1과 3의 높이를 가진 빙산이 있다고 가정해 봅시다.
     * 원래대로라면, 1년 후 빙산의 높이는 각각 0, 1이 될 것입니다.
     * 하지만, 단순히 각 영역의 상하좌우에서 바다의 개수만을 고려해서 빙산을 녹인다고 했을 때, 1이 0이 되는 순간 3이 1에 있던 자리를 0으로 인식해 버려서 결과적으로 높이는 0이 됩니다.
     * 이를 방지하기 위해서, 원래 빙산이 있던 자리는 visited 배열을 통해 true로 처리해 줬고, 설령 원래 있던 자리가 0이 되더라도 그것은 고려하지 않게 됩니다.
     */
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        //전체 지도를 탐색하며 빙산이 있는 좌표를 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    queue.add(new int[]{i, j}); //높이가 있는 칸을 다 큐에 넣기
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) { //근처의 바다 개수를 확인
            int[] now = queue.poll();
//            System.out.println("now = " + now[0] + ", " + now[1]);
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
//                System.out.println("nx = " + nx + " ny = " + ny);
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
//                    System.out.println("nx = " + nx + " ny = " + ny);
                    sea++;
                }
            }
//            System.out.println("count = " + count);
            if (map[now[0]][now[1]] - sea < 0) {
                map[now[0]][now[1]] = 0;
            } else {
                map[now[0]][now[1]] -= sea; //감소
            }
        }
//        System.out.println("---after---");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------");
    }

    private static int bfsCnt(int[][] maps) { //빙하 연결 개수 카운트
        int ans = 0;
        boolean[][] chk = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] != 0 && !chk[i][j]) {
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        int tx = tmp[0];
                        int ty = tmp[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = tx + dx[d];
                            int ny = ty + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (maps[nx][ny] == 0 || chk[nx][ny]) continue;
                            queue.offer(new int[]{nx, ny});
                            chk[nx][ny] = true;
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
