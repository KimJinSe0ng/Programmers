import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sizes;
    static int T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sizes = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int shirtBundle = 0;
        int penBundle = N / P;
        int penPiece = N % P;

        for (int size : sizes) {
            if (size % T == 0) {
                shirtBundle += size / T;
            } else {
                shirtBundle += size / T + 1;
            }
        }

        System.out.printf("%d\n%d %d", shirtBundle, penBundle, penPiece);
    }
}
