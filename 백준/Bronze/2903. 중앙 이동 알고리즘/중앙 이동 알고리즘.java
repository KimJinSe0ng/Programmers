import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dot = (int)Math.pow(2, N) + 1;
        System.out.print(dot*dot);
        br.close();
    }
}