import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Map<String, String> sites;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sites = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            sites.put(site, password);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            if (sites.containsKey(site)) {
                System.out.println(sites.get(site));
            }
        }
    }
}
