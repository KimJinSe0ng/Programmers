import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] visited;
    static int ways = 0;
    static int min_time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        BFS();

        System.out.println(visited[K]);
        System.out.println(ways);
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (visited[now] > min_time) {
                return;
            }
            

            for (int m = 0; m < 3; m++) {
                int next = move(now, m);

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == K) {
                    min_time = visited[now];
                    ways++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
    }

    private static int move(int pos, int index) {
        switch (index) {
            case 0:
                return pos - 1;
            case 1:
                return pos + 1;
            case 2:
                return pos * 2;
        }
        return pos;
    }
}
