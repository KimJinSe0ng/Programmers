import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        System.out.println(canSkill(N));
    }

    private static String canSkill(String N) {
        int mid = N.length() / 2;
        char[] score = N.toCharArray();

        int firstSum = 0;
        for (int i = 0; i < mid; i++) {
            firstSum += score[i] - '0';
        }

        int secondSum = 0;
        for (int i = mid; i < score.length; i++) {
            secondSum += score[i] - '0';
        }

        return (firstSum == secondSum) ? "LUCKY" : "READY";
    }
}
