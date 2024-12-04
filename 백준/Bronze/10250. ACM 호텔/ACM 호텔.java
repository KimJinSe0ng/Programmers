import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, H, W, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            //손님이 배정받을 층 수와 호수 계산
            int floor = N % H == 0 ? H : N % H; //N % H가 0이면 마지막 층
            int room = (N - 1) / H + 1;         //1호부터 시작하기 때문에 (N-1)/H + 1

            //방 번호 출력 (층수*100 + 호수)
            System.out.println(floor * 100 + room);
        }

    }
}
