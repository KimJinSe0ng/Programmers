import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001]; //0~100,000

        BFS(N);
    }

    private static void BFS(int v) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(v, 0));
        visited[v] = true;
        while (!queue.isEmpty()) {
            State now = queue.poll();
            if (now.pos == K) {
                System.out.println(now.depth);
                return;
            }
            for (int d = 0; d < 3; d++) {
                int nextPos = move(now.pos, d);
                if (nextPos < 0 || nextPos > 100000) { //범위 밖이면 pass
                    continue;
                }
                if (!visited[nextPos]) {
                    queue.add(new State(nextPos, now.depth + 1));
                    visited[nextPos] = true;
                }
            }
        }
    }

    private static class State {
        public final int pos;
        public final int depth;

        public State(int pos, int depth) {
            this.pos = pos;
            this.depth = depth;
        }
    }

    private static int move(int pos ,int index) {
        if (index == 0) {
            return pos * 2;
        } else if (index == 1) {
            return pos + 1;
        } else {
            return pos - 1;
        }
    }
}
