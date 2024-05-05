import java.util.*;

class Solution {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static class State {
        public final int x;
        public final int y;
        public final int step;

        public State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited);
    }

    private static int bfs(int[][] maps, boolean[][] visited) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            State now = q.poll();
            if (now.y == maps.length - 1 && now.x == maps[now.y].length - 1) {
                return now.step;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length) {
                    continue;
                }
                if (maps[ny][nx] != 1) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                q.add(new State(nx, ny, now.step + 1));
            }
        }
        return -1;
    }
}