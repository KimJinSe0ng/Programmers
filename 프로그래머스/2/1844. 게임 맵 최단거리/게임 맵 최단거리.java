import java.util.LinkedList;
import java.util.Queue;

class Solution {
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

    private static final int[] dx = {0, 1, 0, -1}; //상하좌우
    private static final int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        //2.방문검사배열
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        //3.초기상태
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 1));
        visited[0][0] = true;
        //4.탐색진행
        while (!q.isEmpty()) {
            State state = q.poll();
            //5.현재상태처리
            if (state.y == maps.length - 1 && state.x == maps[state.y].length - 1) {
                return state.step;
            }
            //6.전이상태생성
            for (int d = 0; d < 4; d++) {
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];
                //7.범위검사
                if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length) {
                    continue;
                }
                //8.유효성검사
                if (maps[ny][nx] != 1) {
                    continue;
                }
                //9.중복검사
                if (visited[ny][nx]) {
                    continue;
                }
                //10.방문처리&상태전이
                visited[ny][nx] = true;
                q.add(new State(nx, ny, state.step + 1));
            }
        }
        return -1; //목표 상태 못 찾을 시
        
    }
}