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
        L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long hashValue = 0;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int charValue = input.charAt(i) - 'a' + 1;
            hashValue = (hashValue + (charValue * power) % M) % M;
            power = (power * r) % M;
        }

        System.out.println(hashValue);
    }
}
