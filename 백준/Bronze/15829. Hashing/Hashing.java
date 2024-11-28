import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int r = 31;
    static int M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String number = st.nextToken();

        long sum = 0;
        for (int i = 0; i < L; i++) {
            sum += (long) ((number.charAt(i) - 'a' + 1) * Math.pow(r, i)) % M;
        }
        System.out.println(sum);
    }
}
