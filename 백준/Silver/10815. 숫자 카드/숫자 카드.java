import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cards;
    static int[] guess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        guess = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            guess[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int i = 0; i < guess.length; i++) {
            int s = 0;
            int e = N - 1;
            boolean find = false;
            while (s <= e) {
                if (cards[s] == guess[i] || cards[e] == guess[i]) {
                    find = true;
                    break;
                }
                int mid = (s + e) / 2;

                if (cards[mid] > guess[i]) { //현재 값이 찾는 값 보다 크다면
                    e = mid - 1;
                } else if (cards[mid] < guess[i]) { //현재 값이 찾는 값 보다 작다면
                    s = mid + 1;
                } else { //현재 값이 찾는 값이면
                    find = true;
                    break;
                }
            }
            if (find) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
