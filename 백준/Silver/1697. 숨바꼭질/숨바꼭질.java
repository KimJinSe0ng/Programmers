import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] time; //visited
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100001]; //0~100,000

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        BFS();
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int d = 0; d < 3; d++) {
                int next = move(now, d);

                if (next < 0 || next > 100000) { //범위 밖이면 pass
                    continue;
                }

                if (next == K) {
                    System.out.println(time[now]);
                    return;
                }

                if (time[next] == 0) { //첫 방문
                    queue.add(next);
                    time[next] = time[now] + 1;
                }

            }
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
