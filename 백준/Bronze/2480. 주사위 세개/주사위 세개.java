import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (a == b && a == c) {
            System.out.print(10000+a*1000);
        } else if (a == b) {
            System.out.print(1000+a*100);
        } else if (a == c) {
            System.out.print(1000+a*100);
        } else if (b == c) {
            System.out.print(1000+b*100);
        } else {
            System.out.print(Math.max(a,Math.max(b,c)) * 100);
        }
    }
}