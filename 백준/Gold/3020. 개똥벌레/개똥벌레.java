import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int h = Integer.parseInt(st.nextToken());

        int[] line = new int[h];

        for (int t = 0; t < n; t++) {
            int height = Integer.parseInt(br.readLine());

            if (t % 2 == 0) {
                line[0] += 1;
                if (height < h) {
                    line[height] -= 1; 
                }
            } else { 
                line[h - height] += 1;
            }

        }

        int[] prefix = new int[h]; 
        prefix[0] = line[0];

        for (int i = 1; i < h; i++) {
            prefix[i] = prefix[i - 1] + line[i];
        }
        
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < h; i++) {
            if (prefix[i] < min) {
                min = prefix[i];
                count = 1;
            } else if (prefix[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
