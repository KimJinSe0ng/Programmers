import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, minCnt;
    static ArrayList<Integer> Val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Val = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            if(K - value > 0){
                Val.add(value);
            } else if(K - value < 0){
            } else{
                minCnt = 1;
            }
        }

        if(minCnt == 1){
            System.out.println(minCnt);
            return;
        }
        minCnt = 0;

        for(int i = Val.size()-1; i >= 0; i--) {
            if (K - Val.get(i) >= 0) {
                minCnt += (K / Val.get(i));
                K -= Val.get(i) * (K / Val.get(i));
            }
            if(K == 0){
                break;
            }
        }
        System.out.println(minCnt);
    }
}