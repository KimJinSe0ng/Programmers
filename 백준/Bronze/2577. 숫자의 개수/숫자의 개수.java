import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());

        int multiple = a * b * c;
        num = new int[10]; //0~9

        String abc = String.valueOf(multiple);
        String[] divided_abc = abc.split("");
        for (int i = 0; i < divided_abc.length; i++) {
            int index = Integer.parseInt(divided_abc[i]);
            num[index]++;
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
