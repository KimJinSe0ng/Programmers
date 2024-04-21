import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] click;
    static boolean isArrival;
    public static void main(String[] args) throws IOException{
        //총 F층, 회사 위치 G, 내 위치 S, G층으로 이동하려고 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int[] moves = {U, D};
        visited = new boolean[F + 1];
        click = new int[F + 1];
        bfs(S, moves);
        if (isArrival) {
            System.out.println(click[G]);
        } else {
            System.out.println("use the stairs");
        }
    }

    private static void bfs(int start, int[] moves) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        click[start] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == G) {
                isArrival = true;
                return;
            }
            for (int i = 0; i < moves.length; i++) {
                int next = getNext(moves, now, i);
//                System.out.println("next = " + next);
                if (next >= 1 && next <= F) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                        click[next] = click[now] + 1; //깊이 계산
//                        System.out.println("click[" + next + "] = " + click[next]);
                    }
                }
            }
        }
    }

    private static int getNext(int[] moves, int now, int i) {
        int next = now;
        if (i == 0) {
            next = now + moves[0];
        } else {
            next = now - moves[1];
        }
        return next;
    }

}
