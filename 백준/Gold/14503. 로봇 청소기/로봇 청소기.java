import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r, c, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; //북동남서
    static int[][] map;
    static boolean[][] visited;
    static int clear = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        //0 : 빈칸, 1: 벽
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(r, c, d);
        System.out.println(clear);
    }

    private static void bfs(int x, int y, int d) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        clear++;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            //1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            for (int i = 0; i < 4; i++) { //현재 위치에서 현재 방향을 기준으로 반시계부터 차례대로 탐색을 진행한다. -> 청소 유무를 확인하기 위해
                d = (d + 3) % 4; //3-2.반시계 방향으로 90도 회전
                int nx = now[0] + dx[d]; //북동남서
                int ny = now[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    //3-1.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        //3-3.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진하다.
                        q.add(new int[]{nx, ny}); //전진
                        //3-4.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
                        visited[nx][ny] = true; //현재 칸 청소
                        clear++;
                        break;
                    }
                }
            }
            //2-1.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (q.isEmpty()) {
                //2-3.바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                int back = (d + 2) % 4;
                int nx = now[0] + dx[back];
                int ny = now[1] + dy[back];
//                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] != 1) {
                        //2-2.바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                        q.add(new int[]{nx, ny});
                    }
//                }
            }
        }
    }
}
