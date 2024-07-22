import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] days;
    static int[] income;
    static int[] D; //D[i] : i번째 날부터 퇴사날까지 벌 수 있는 최대 수입
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        days = new int[N + 1];
        income = new int[N + 1];
        D = new int[N + 2]; //오늘부터 퇴사일 까지 벌 수 있는 최대 수입

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            income[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + days[i] > N + 1) { //i번째 상담을 퇴사일까지 끝낼 수 없을 때
                D[i] = D[i + 1];
            } else { //i번째 상담을 퇴사일까지 끝낼 수 있을 때
                D[i] = Math.max(D[i + 1], income[i] + D[i + days[i]]);
            }
        }
        System.out.println(D[1]);
    }
}
