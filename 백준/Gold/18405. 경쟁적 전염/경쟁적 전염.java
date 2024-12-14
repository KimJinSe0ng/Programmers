import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int S, X, Y;
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0) {
                    virusList.add(new Virus(graph[i][j], i, j, 0));
                }
            }
        }

        virusList.sort(Comparator.comparingInt(v -> v.no));

        Queue<Virus> virusQueue = new LinkedList<>(virusList);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs(virusQueue);

        System.out.println(graph[X - 1][Y - 1]);
    }

    private static void bfs(Queue<Virus> virusQueue) {
        while (!virusQueue.isEmpty()) {
            Virus now = virusQueue.poll();

            if (now.time == S) break;

            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < N && graph[ny][nx] == 0) {
                    graph[ny][nx] = now.no;
                    virusQueue.add(new Virus(now.no, ny, nx, now.time + 1));
                }
            }

        }
    }

    private static class Virus {
        public int no;
        public int y;
        public int x;
        public int time;

        public Virus(int no, int y, int x, int time) {
            this.no = no;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

}
