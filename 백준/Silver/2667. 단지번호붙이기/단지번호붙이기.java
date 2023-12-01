import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j);
                    answer++;
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        for(int i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= n || ny >= n || nx < 0 || ny < 0) {
                continue;
            }
            if(arr[nx][ny] == 0) {
                continue;
            }
            arr[x][y] = 0;
            arr[nx][ny] = 0;
            dfs(nx, ny);
            cnt++;
        }
    }
}