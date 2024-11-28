import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Set<String> d = new HashSet<>();
    static Set<String> b = new HashSet<>();
    static List<String> names = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            d.add(name);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            b.add(name);
        }

        if (d.size() > b.size()) {
            for (String name : d) {
                if (b.contains(name)) {
                    names.add(name);
                }
            }
        } else {
            for (String name : b) {
                if (d.contains(name)) {
                    names.add(name);
                }
            }
        }

        Collections.sort(names);
        
        sb.append(names.size()).append("\n");
        for (String name : names) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
