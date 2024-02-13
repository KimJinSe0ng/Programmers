import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //11720
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        
        char[] num_list = num.toCharArray();

        int sum = 0;
        for (int i = 0; i < num_list.length; i++) {
            sum += num_list[i] - '0';
        }
        System.out.println(sum);
    }
}
