import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[][] apartment;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        apartment = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            apartment[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(apartment[k][n]);
        }
    }
}
