import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int hour;
        if ((60 + M - 45) / 60 == 1) {
            hour = (24 + H) % 24;
        } else {
            hour = (24 + H -1) % 24;
        }
        int min = (60 + M - 45) % 60;
        System.out.printf("%d %d\n", hour, min);
    }
}
