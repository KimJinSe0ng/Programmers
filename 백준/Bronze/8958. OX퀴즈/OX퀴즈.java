import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int score = 1;
            int[] answers = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    answers[j] = score++;
                } else {
                    score = 1;
                }
            }

            int sum = 0;
            for (int k = 0; k < answers.length; k++) {
                sum += answers[k];
            }
            System.out.println(sum);
        }
    }
}
