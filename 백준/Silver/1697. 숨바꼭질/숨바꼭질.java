import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] movable = {-1, 1, 2}; //X-1, X+1, X*2
//    static boolean visited[];
    static int visited[];
//    static int[] move;
    public static void main(String[] args) {
        /**
         * 수빈이는 현재 점 N, 동생은 점 K에 있다.
         * 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 or X+1로 이동
         * 순간이동의 경우 1초 후에 2*X로 이동
         * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인가?
         */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new int[100001];
//        visited = new boolean[100001];
//        move = new int[100001];
        if (N == K) {
            System.out.println("0");
        } else {
            BFS(N);
        }
//        System.out.println(move[K]);
    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
//        visited[x] = true;
//        move[x] = 1;
        visited[x] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i != 2) {
                    nx = now + movable[i];
                } else {
                    nx = now * movable[i];
                }
                if (nx == K) {
//                    System.out.println("move[now] = " + move[now]);
//                    move[nx] = move[now];
                    System.out.println(visited[now]);
                    return;
                }
                if (nx >= 0 && nx <= 100000) {
                    if (visited[nx] == 0) {
//                        visited[nx] = 1;
                        queue.add(nx);
//                        move[nx] = move[now] + 1;
                        visited[nx] = visited[now] + 1;
                    }
                }
//                if (nx == K) {
//                    System.out.println("nx = " + nx);
//                    System.out.println("move[nx] = " + move[nx]);
//                    System.out.println("now = " + now);
//                    return;
//                }
            }
        }
    }
}
