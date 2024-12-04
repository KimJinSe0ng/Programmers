import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String input = st.nextToken();

        for (int i = 0; i < 26; i++) {
            char currentChar = (char) (i + 'a');
            int idx = input.indexOf(currentChar);
            sb.append(idx).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
