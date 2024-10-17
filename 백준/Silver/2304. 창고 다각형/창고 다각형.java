import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] graph = new int[1001];
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x] = y;
            xList.add(x);
            yList.add(y);
        }

        int maxHeight = 0;
        for (int height : yList) { 
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        int maxWidth = 0;
        for (int width : xList) {
            if (width > maxWidth) {
                maxWidth = width;
            }
        }


        int[] prefix = new int[maxWidth + 2]; 
        int[] suffix = new int[maxWidth + 2];

        ArrayList<Integer> maxPoint = new ArrayList<>();

        int h = 0;
        for (int f = 1; f < maxWidth + 3; f++) {
            if (graph[f] == maxHeight) {
                maxPoint.add(f);
                break;
            }
            h = Math.max(h, graph[f]);
            prefix[f] = prefix[f - 1] + h;
        }

        h = 0;
        for (int b = maxWidth; b > 0; b--) {
            if (graph[b] == maxHeight) {
                maxPoint.add(b);
                break;
            }
            h = Math.max(h, graph[b]);
            suffix[b] = suffix[b + 1] + h;
        }

        int answer = max(prefix) + max(suffix);
        if (maxPoint.size() == 2) {
            answer += (maxPoint.get(1) - maxPoint.get(0) + 1) * maxHeight;
        }

        System.out.println(answer);
        scanner.close();
    }

    private static int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
