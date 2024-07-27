import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);

        int count = 0;

        int[][] arr2 = new int[n - 1][2]; //GCD가 1이 아닌 인접쌍 저장하는 배열 [42, 2184], [2184, 2200]
        int arr2Index = 0; //배열에 실제 저장된 쌍의 개수

        //GCD가 1이 아닌 인접쌍 찾기
        for (int i = 0; i < n - 1; i++) {
            if (gcd(arr[i], arr[i + 1]) > 1) {
                arr2[arr2Index][0] = arr[i];
                arr2[arr2Index][1] = arr[i + 1];
                arr2Index++;
            }
        }

        for (int i = 0; i < arr2Index; i++) {
            int a = arr2[i][0]; //42
            int b = arr2[i][1]; //2184

            for (int j = a + 1; j < b; j++) { //43~2183
                int tmp = 0;

                if (gcd(a, j) == 1) tmp += 1; //a의 최대 공약수는 1
                if (gcd(b, j) == 1) tmp += 1; //b의 최대 공약수는 1

                if (tmp > 1) { //a, b의 최대 공약수가 둘 다 1이면 count 1증가
                    count++;
                    break;
                }
                if (j == b - 1) { //2183까지 왔는데 최대 공약수가 1이 아니라면 2개의 수를 추가해야 하는 경우
                    count += 2;
                }
            }
        }

        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}