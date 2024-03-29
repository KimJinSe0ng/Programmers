class Solution {
    private static final int[] dx = {0, 1, -1}; //아래, 오른쪽, 왼쪽 위
    private static final int[] dy = {1, 0, -1};
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;

        //리팩터링 후
        int d = 0; //방향 변수
        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                //nx == n || ny == n는 아래, 오른쪽을 진행할 때 위한 조건
                //nx == -1 || ny == -1는 왼쪽 위를 진행할 때 위한 조건
                //triangle[ny][nx] != 0는 이미 숫자가 써 있는 칸에 도달했을 때 조건
                //이 조건에 걸리면 현재 진행 방향으로 더 이상 진행할 수 없다. 방향 변수의 값을 증가 시켜 방향을 바꾼다.
                //0,1,2에서 2를 넘어가면 다시 0으로 돌아오게 하는 것은 나머지 연산으로 이용할 수 있다.
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    //전환된 방향으로도 진행을 못하는 경우 = 모든 숫자가 다 채워졌을 때 숫자 채우기 종료
                    break;
                }
            }
            x = nx; //nx, ny에는 진행할 수 있는 방향 위치가 들어있다. 현재 위치 업데이트
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}