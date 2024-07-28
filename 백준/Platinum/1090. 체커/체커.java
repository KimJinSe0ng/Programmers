import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { //메모리 초과
    static int N;
    static int[][] checkers;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        checkers = new int[N][2];
        answer = new int[N];
        int[] arr_x = new int[N]; //x좌표
        int[] arr_y = new int[N]; //y좌표
        Arrays.fill(answer, -1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            checkers[i][0] = Integer.parseInt(st.nextToken());
            checkers[i][1] = Integer.parseInt(st.nextToken());
            arr_x[i] = checkers[i][0];
            arr_y[i] = checkers[i][1];
        }

        int[] tmp = new int[N];
        for (int x : arr_x) { //모든 좌표 탐색
            for (int y : arr_y) {
                for (int i = 0; i < checkers.length; i++) {
                    tmp[i] = Math.abs(x - checkers[i][0]) + Math.abs(y - checkers[i][1]); //거리 비용
                }

                Arrays.sort(tmp);

                int sum = 0;
                for (int i = 0; i < tmp.length; i++) {
                    sum += tmp[i];
                    if (answer[i] == -1) {
                        answer[i] = sum;
                    } else {
                        answer[i] = Math.min(answer[i], sum);
                    }
                }
            }
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}
