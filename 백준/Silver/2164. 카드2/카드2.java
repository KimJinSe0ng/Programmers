import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }

        while (cards.size() != 1) {
            int removedCard = cards.poll();
            int addCard = cards.poll();
            cards.add(addCard);
        }

        System.out.println(cards.poll());
    }
}
