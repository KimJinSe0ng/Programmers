import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 재귀
    static int N;
    static int[][] interview;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        interview = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            interview[i][0] = Integer.parseInt(st.nextToken());
            interview[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);
        System.out.println(answer);
    }

    public static void recur(int day, int price) {
        if (day == N) {
            if (price >= answer) {
                answer = price;
            }
            return;
        }

        if (day > N) {
            return;
        }

        // 상담을 한다면
        recur(day + interview[day][0], price + interview[day][1]);
        // 상담을 안 한다면
        recur(day + 1, price);
    }
}
