import java.io.*;
import java.util.*;

public class Main {
    static int M, K, T;
    static int[] D = new int[51];
    static double[] probability = new double[51];
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        T = 0; // 전체 조약돌의 개수
        for (int i = 0; i < M; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            T += D[i];
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        answer = 0.0;
        for (int i = 0; i < M; i++) {
            // 선택 조약돌 개수보다 현재 색 조약돌 개수가 적으면 모두 같은 색으로 뽑을 확률은 0
            if (D[i] >= K) {
                probability[i] = 1.0;
                for (int j = 0; j < K; j++) {
                    // i 색깔을 모두 뽑을 확률 = i 색깔을 모두 뽑을 확률 * 현재 색깔 개수 - j / 전체 색깔 개수 - j;
                    probability[i] *= (double) (D[i] - j) / (T - j);
                }
                answer += probability[i];
            }
        }
        System.out.println(answer);
    }
}
