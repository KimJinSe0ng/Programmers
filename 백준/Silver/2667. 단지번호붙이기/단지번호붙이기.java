import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}; //상화좌우 탐색을 위한 배열
    static int[] dy = {1, 0, -1, 0}; //오른쪽, 아래, 위, 왼쪽
    static int[][] map;
    static boolean[][] visited;
    static int[] apartments = new int[25 * 25];
    static int apartmentsNum = 0; //아파트 단지 번호의 수
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartmentsNum++;
                    BFS(i, j);
                }
            }
        }
        Arrays.sort(apartments);
        System.out.println(apartmentsNum);
        for (int i = 0; i < apartments.length; i++) {
            if (apartments[i] == 0) {
            } else {
                System.out.println(apartments[i]);
            }
        }
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        apartments[apartmentsNum]++;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
//            System.out.println("now = " + now[0] + " " + now[1]);
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        apartments[apartmentsNum]++;
                    }
                }
            }
        }
    }
}
