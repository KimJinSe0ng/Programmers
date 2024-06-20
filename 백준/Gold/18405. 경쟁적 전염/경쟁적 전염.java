import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, S, X, Y;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static PriorityQueue<Virus> queue = new PriorityQueue<>();
    static int second = 0;

    private static class Virus implements Comparable<Virus> {
        public final int x;
        public final int y;
        public final int value;

        public Virus(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Virus other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    queue.add(new Virus(i, j, map[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for (int s = 0; s < S; s++) {
            if (queue.isEmpty()) break;
            int size = queue.size();
            PriorityQueue<Virus> nextQueue = new PriorityQueue<>();
            while (size-- > 0) {
                Virus now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = now.value;
                            nextQueue.add(new Virus(nx, ny, now.value));
                        }
                    }
                }
            }
            queue = nextQueue;
        }

        System.out.println(map[X - 1][Y - 1]);
    }
}
