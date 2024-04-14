import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] visited;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        time = new int[100001];
        bfs(n);
        System.out.println(time[k]);
    }

    private static void bfs(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == k) { //예외 : 시작 부터 수빈이를 만나면
                return;
            }
            for (int i = 0; i < 3; i++) {
                int moved = move(cur, i);
                if (moved >= 0 && moved <= 100000) {
                    if (!visited[moved]) {
                        visited[moved] = true;
                        time[moved] = time[cur] + 1;
                        queue.add(moved);
                    }
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
