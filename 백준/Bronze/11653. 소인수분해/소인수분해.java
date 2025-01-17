import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int divider = 2;
        while (N > 1) {
            if (N % divider == 0) {
                N /= divider;
                System.out.println(divider);
            } else {
                divider++;
            }
        }
    }
}
