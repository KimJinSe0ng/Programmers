import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] map;
	private static boolean[][] visit;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		int max = 0;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		int answer = 0;
		for (int i=1; i<=max; i++) {
			int cnt = 0;
			visit = new boolean[n+1][n+1];
			for (int j=1; j<=n; j++) {
				for (int k=1; k<=n; k++) {
					if (!visit[j][k] && map[j][k] >= i) {
						cnt++;
						dfs(i, j, k);
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
		
	}

	private static void dfs(int height, int x, int y) {
		
		visit[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > n || ny > n) {
				continue;
			}
			
			if (!visit[nx][ny] && map[nx][ny] >= height) {
				visit[nx][ny] = true;
				dfs(height, nx, ny);
			}
		}
		
	}
}