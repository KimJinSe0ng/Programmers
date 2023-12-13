import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int M,N, K;
    static int map[][];

    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken());   
        N = Integer.parseInt(st.nextToken());   
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];


        for (int i = 0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int preX = Integer.parseInt(st.nextToken());
            int preY = Integer.parseInt(st.nextToken());
            int posX = Integer.parseInt(st.nextToken());
            int posY = Integer.parseInt(st.nextToken());

            for (int j = preX; j < posX ; j++) {	
                for (int k = preY; k < posY ; k++) {
                    map[k][j] = 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N ; k++) {
                if(map[i][k] == 0){
                    count = 0;
                    dfs2(i,k);
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer temp : list){
            System.out.print(temp + " ");
        }
    }


    static void dfs2(int x, int y){
        map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            if(map[nx][ny] == 0) dfs2(nx,ny);
        }

    }
}