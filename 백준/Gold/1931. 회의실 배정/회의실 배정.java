import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); 
            return Integer.compare(a[1], b[1]); 
        });

        int count = 0;
        int lastEndTime = 0; 

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEndTime) { 
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        System.out.println(count);
    }
}
