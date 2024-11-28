import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int TC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer> priority = new ArrayList<>();
            Queue<Document> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int important = Integer.parseInt(st.nextToken());
                priority.add(important);
                queue.add(new Document(j, important));
            }

            priority.sort(Collections.reverseOrder());

            int idx = 0;

            while (!queue.isEmpty()) {
                Document cur = queue.poll();
                if (cur.important == priority.get(0)) {
                    idx++;
                    priority.remove(0);
                    if (cur.idx == M) {
                        sb.append(idx).append("\n");
                        break;
                    }
                } else {
                    queue.add(cur);
                }
            }
        }
        System.out.println(sb);
    }

    private static class Document {
        public int idx;
        public int important;

        public Document(int idx, int important) {
            this.idx = idx;
            this.important = important;
        }
    }
}
