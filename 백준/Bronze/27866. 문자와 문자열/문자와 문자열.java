import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());

        System.out.println(S.charAt(i - 1));
    }
}
