import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == b && b == c && c == 0) break;

            if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) {
                System.out.println("right");
            } else if (Math.pow(b, 2) == Math.pow(c, 2) + Math.pow(a, 2)){
                System.out.println("right");
            } else if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}