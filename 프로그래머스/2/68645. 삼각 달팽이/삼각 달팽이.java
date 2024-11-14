class Solution {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    public int[] solution(int n) {
        int[][] t = new int[n][n];
        int x = 0;
        int y = 0;
        int v = 1;
        int d = 0;
        
        while(true) {
            t[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            //더 이상 진행할 수 없을 때 처리
            if(nx == n || ny == n || nx == -1 || ny == -1 || t[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                //전환된 방향으로도 진행을 못하는 경우
                if(nx == n || ny == n || nx == -1 || ny == -1 || t[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }
        
        int[] result = new int[v - 1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = t[i][j];
            }
        }
        
        return result;
    }
}