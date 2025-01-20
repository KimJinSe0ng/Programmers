import java.io.*;
import java.util.*;

public class Main {
    static int[] pieces = new int[] {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 6; i++) {
            int piece = Integer.parseInt(st.nextToken());
            sb.append(pieces[i] - piece).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}
