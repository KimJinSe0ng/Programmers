import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] str = st.nextToken().split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) {
                answer = answer + temp; //가장 앞에 있는 값만 더함
            } else {
                answer = answer - temp; //뒷 부분은 더한 값들을 뺌
            }
        }

        System.out.println(answer);
    }

    static int mySum(String a) { //나뉜 그룹의 더하기 연산 수행 함수
        int sum = 0;
        String[] temp = a.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
