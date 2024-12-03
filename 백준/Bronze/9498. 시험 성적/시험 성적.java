import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        score = Integer.parseInt(st.nextToken());

        System.out.println(calculate(score));
    }

    private static String calculate(int score) {
        if (score >= 60 && score < 70) return "D";
        else if (score >= 70 && score < 80) return "C";
        else if (score >= 80 && score < 90) return "B";
        else if (score >= 90) return "A";
        else return "F";
    }
}
