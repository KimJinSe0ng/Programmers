import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] visited;
    static int[] time;
    static int minTime = Integer.MAX_VALUE;
    static int way = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        time = new int[100001];
        
        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }
        
        bfs(n);
        System.out.println(time[k]);
        System.out.println(way);
    }

    private static void bfs(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < time[now]) return;

            for (int i = 0; i < 3; i++) {
                int next = move(now, i);

                if (next < 0 || next > 100000) continue;

                if (next == k) { //예외 : 시작 부터 수빈이를 만나면
                    minTime = time[now];
                    way++;
                }

                if (time[next] == 0 || time[next] == time[now] + 1) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    private static int move(int now, int index) {
        switch (index) {
            case 0:
                now -= 1;
                break;
            case 1:
                now += 1;
                break;
            case 2:
                now *= 2;
                break;
        }
        return now;
    }
}
