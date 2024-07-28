import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ingredient;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ingredient = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void recur(int idx, int sour, int bitter, int use) {
        if (idx == N) { //음식을 모두 사용했다면
            if (use == 0) { //아무 재료도 사용하지 않았다면 그냥 종료
                return;
            }
            int result = Math.abs(sour - bitter);
            answer = Math.min(answer, result);
            return;
        }
        //재귀 함수는 모든 경우의 수를 구현해야 함
        //재료를 사용한 경우
        recur(idx + 1, sour * ingredient[idx][0], bitter + ingredient[idx][1], use + 1);
        //재료를 사용하지 않은 경우
        recur(idx + 1, sour, bitter, use);
    }
}
