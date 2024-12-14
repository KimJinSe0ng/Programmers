import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int totalComparison = 0;
        while (cards.size() > 1) {
            int first = cards.poll();
            int second = cards.poll();
            int combined = first + second;

            totalComparison += combined;
            cards.add(combined);
        }

        System.out.println(totalComparison);

    }

}
