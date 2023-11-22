import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken(); String B = st.nextToken();

        char aChar0 = A.charAt(0); char aChar1 = A.charAt(1); char aChar2 = A.charAt(2);
        char bChar0 = B.charAt(0); char bChar1 = B.charAt(1); char bChar2 = B.charAt(2);

        StringBuffer sb = new StringBuffer();
        if(aChar2 > bChar2 || (aChar2 == bChar2 && aChar1 > bChar1) || (aChar2 == bChar2 && aChar1 == bChar1 && aChar0 > bChar0)) {
            sb.append(A);
            System.out.println(sb.reverse());
        } else {
            sb.append(B);
            System.out.println(sb.reverse());
        }

        br.close();
    }
}