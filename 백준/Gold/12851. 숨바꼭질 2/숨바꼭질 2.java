import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    static int[] time;
    static int minTime = Integer.MAX_VALUE; //제일 낮은 깊이
    static int way = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001]; //0~100,000
        time = new int[100001];

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        BFS(N);
        System.out.println(time[K]);
        System.out.println(way);
    }

    private static void BFS(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < time[now]) {
                return;
            }

            for (int d = 0; d < 3; d++) {
                int nextPos = move(now, d);

                if (nextPos < 0 || nextPos > 100000) { //범위 밖이면 pass
                    continue;
                }

                if (nextPos == K) {
                    minTime = time[now]; //수빈이를 만난 최단시간
                    way++;
                }

                //방문하지 않았거나 한번의 이동으로 방문할 수 있다면 -> 이 위치를 최단 시간으로 방문할 수 있는 또 다른 경로를 발견한 경우
                if (time[nextPos] == 0 || time[nextPos] == time[now] + 1) {
                    queue.add(nextPos);
                    time[nextPos] = time[now] + 1;
//                    visited[nextPos] = true;
                }
            }
        }
    }

    private static int move(int pos ,int index) {
        if (index == 0) {
            return pos - 1;
        } else if (index == 1) {
            return pos + 1;
        } else {
            return pos * 2;
        }
    }
}
