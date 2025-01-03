import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        System.out.println(AcompareWithB(A, B));
    }

    private static String AcompareWithB(int a, int b) {
        if (a > b) return ">";
        else if (a < b) return "<";
        else return "==";
    }
}
