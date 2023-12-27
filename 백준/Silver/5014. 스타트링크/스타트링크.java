import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean visited[];
    static int[] results;
    static ArrayList<Integer> buttons;
    public static void main(String[] args) throws IOException {
        /**
         * 건물 : 총 F층
         * 스타트링크가 있는 곳 : G층
         * 강호가 있는 곳 : S층
         * 위로 U층을 가는 버튼 : U
         * 아래로 D층을 가는 버튼 : D
         * U층 위, D층 아래에 해당하는 층이 없을 때는 엘리베이터는 움직이지 않음
         * G층에 갈 수 없다면 "use the stairs"를 출력
         * 강호가 G층에 도착하려면, 버튼을 최소 몇번 눌러야 하는지 구하라.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        results = new int[F+1];
        buttons = new ArrayList<>();
        buttons.add(U);
        buttons.add(D);
        BFS(S);
    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        results[x] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
//            System.out.println("now = " + now);
            if (now == G) {
//                System.out.println("results = " + results[now]);
                System.out.println(results[now]);
                return;
            }
            for (int i = 0; i < buttons.size(); i++) {
                int nx;
                if (i == 0) {
                    nx = now + buttons.get(i); //U
                } else {
                    nx = now - buttons.get(i); //D
                }
//                System.out.println("nx = " + nx);
                if (nx >= 1 && nx < F+1) {
                    if (!visited[nx]) {
                        visited[nx] = true;
                        queue.add(nx);
                        results[nx] = results[now] + 1;
                    }
                }
            }
        }
        System.out.println("use the stairs");
    }
}
