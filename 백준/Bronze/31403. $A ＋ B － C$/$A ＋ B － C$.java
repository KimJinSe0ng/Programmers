import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());

        digit(a, b, c);
        str(a, b, c);
    }

    private static void digit(int a, int b, int c) {
        System.out.println(a + b - c);
    }

    private static void str(int a, int b, int c) {
        int ab = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        System.out.println(ab - c);
    }
}
