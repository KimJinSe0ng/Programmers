import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] people = new int[N][2];
        int[] ranks = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i][0] = weight;
            people[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank++;
                }
            }

            ranks[i] = rank;
        }

        StringBuilder sb = new StringBuilder();

        for (int rank : ranks) {
            sb.append(rank).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
