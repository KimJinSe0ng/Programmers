import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int totalPopulation = population[x][y];
        int count = 1; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(population[cx][cy] - population[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        totalPopulation += population[nx][ny];
                        count++;
                    }
                }
            }
        }

        if (count > 1) { 
            int newPopulation = totalPopulation / count;
            for (int[] cell : union) {
                population[cell[0]][cell[1]] = newPopulation;
            }
            return true;
        }

        return false; 
    }
}
