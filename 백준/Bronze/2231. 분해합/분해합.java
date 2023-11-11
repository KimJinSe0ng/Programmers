import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;  //답
        for (int i = 1; i < n; i++) {
            int num = function(i);
            if (num == n) { //분해합이 n과 같으면 i는 n의 생성자가 된다
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }

    //분해합 구하는 함수
    static int function(int n) {
        int ret = n;
        while (n != 0) {
            ret += n % 10;
            n /= 10;
        }
        return ret;
    }
}