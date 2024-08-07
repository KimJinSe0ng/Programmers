import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] checkers;
//    static int min_x = Integer.MAX_VALUE;
//    static int max_x = Integer.MIN_VALUE;
//    static int min_y = Integer.MAX_VALUE;
//    static int max_y = Integer.MIN_VALUE;
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
//            min_x = Math.min(x, min_x);
//            min_y = Math.min(y, min_y);
//            max_x = Math.max(x, max_x);
//            max_y = Math.max(y, max_y);
        }

        int[] temp = new int[N];

        for (int x : arr_x)
        {
            for (int y : arr_y) {
                for (int i = 0; i < checkers.length; i++) {
                    temp[i] = Math.abs(x - checkers[i][0]) + Math.abs(y - checkers[i][1]);
                }

                Arrays.sort(temp); //짧은 거리 순으로 정렬되어 있음
                
                int sum = 0;
                for (int i = 0; i < temp.length; i++) {
                    sum += temp[i];
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
