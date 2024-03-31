import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;

    static int[][] dist;    
    static boolean[][][] visit;    

    public static int[] dx = {-1, 0, 1, 0};

    public static int[] dy = {0, 1, 0, -1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];
        visit = new boolean[2][N][M];

 
        if (N - 1 == 0 && M - 1 == 0) {
            System.out.print(1);
            System.exit(0);
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        BFS();
        System.out.println(result);

    }

    private static void BFS() {
        LinkedList<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 0});
        arr[0][0] = -1;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2]; 

            for (int i = 0; i < 4; i++) {
                int nowX = x + dx[i];
                int nowY = y + dy[i];

                if (nowX < 0 || nowY < 0 || N <= nowX || M <= nowY) {
                    continue;
                }

                if (arr[nowX][nowY] == 1) {
                    if (z == 0 && !visit[1][nowX][nowY]) {
                        visit[z][nowX][nowY] = true;   
                        dist[nowX][nowY] = dist[x][y] + 1; 
                        que.offer(new int[]{nowX, nowY, 1});
                    }
                } else {
                    if (!visit[z][nowX][nowY]) {
                        visit[z][nowX][nowY] = true;   
                        dist[nowX][nowY] = dist[x][y] + 1; 
                        que.offer(new int[]{nowX, nowY, z}); 
                    }
                }

                if (nowX == N - 1 && nowY == M - 1) {
                    result = dist[nowX][nowY] + 1;
                    return;
                }
            }
        }
    }
}