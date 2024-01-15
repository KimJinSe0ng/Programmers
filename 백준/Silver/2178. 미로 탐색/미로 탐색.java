import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 완전 탐색을 진행하며 몇 번째 깊이에서 원하는 값을 찾을 수 있는지를 구하는 것과 동일하다.
     * BFS를 사용해 최초로 도달했을 때 깊이를 출력하면 된다.
     * DFS보다 BFS가 적잡한 이유는 BFS는 해당 깊이에서 갈 수 있는 노드 탐색을 마친 후 다음 깊이로 넘어가기 때문이다.
     */
    static int[] dx = {0, 1, 0, -1}; //상화좌우 탐색을 위한 배열
    static int[] dy = {1, 0, -1, 0}; //오른쪽, 아래, 위, 왼쪽
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    /**
     * 선언과 동시에 배열의 크기 지정 및 값 초기화
     * int[] arr = {1,2,3,4,5};
     * int[] arr = new int[]  {1,3,5,2,4};
     * Queue
     * add() : 큐가 꽉 찬 경우 IllegalStateException 에러 발생
     * offer() : 큐가 꽉 찬 경우 false 반환
     * remove() : 큐가 비어 있는 경우 NoSuchElementException 에러 발생
     * poll() : 큐가 비어 있을 경우 null 반환
     */
    public static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) { //좌표 유효성 검사
                    if (A[x][y] != 0 && !visited[x][y]) { //갈수 있는 칸 && 방문 검사
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //깊이 업데이트
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
