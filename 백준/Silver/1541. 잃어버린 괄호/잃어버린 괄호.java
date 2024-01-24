import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        String[] arr = br.readLine().split("-");

        for(int i=0; i<arr.length; i++) {
            int tmp = 0;

            String[] add = arr[i].split("\\+");
            for(int j=0; j<add.length; j++) {
                tmp += Integer.parseInt(add[j]);
            }

            if(sum==Integer.MAX_VALUE) { 
                sum = tmp;
            }else { 
                sum -= tmp;
            }
        }
        System.out.println(sum);

    }
}