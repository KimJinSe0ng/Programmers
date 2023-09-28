import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

interface Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] input = br.readLine().split(" ");
        String S = input[0];
        int B = Integer.parseInt(input[1]);
        int result = 0;
        int len = S.length();
        for(int i=0; i<len; i++) {
            int val = S.charAt(len-i-1)-55;
            if(val < 10) {
                val = val + 7;
            }
            result += val * Math.pow(B, i);
        }
        System.out.println(result);
    }
}