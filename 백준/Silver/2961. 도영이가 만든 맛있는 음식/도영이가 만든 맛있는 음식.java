import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] items;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        items = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void recur(int idx, int sour, int bitter, int use) {
        if (idx == N) { //재료를 다 썼으면 종료
            if (use == 0) { //재료를 하나도 사용하지 않은 경우 종료
                return;
            }
            int diff = Math.abs(sour - bitter);
            answer = Math.min(diff, answer);
            return;
        }

        //재료를 사용한 경우
        recur(idx + 1, sour * items[idx][0], bitter + items[idx][1], use + 1);
        //재료를 쓰지 않은 경우 : 다음 재료 선택
        recur(idx + 1, sour, bitter, use);
    }
}