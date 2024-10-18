import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = input[0].charAt(0) - 'A' + 1;
            int b = input[1].charAt(0) == '.' ? -18 : input[1].charAt(0) - 'A' + 1;
            int c = input[2].charAt(0) == '.' ? -18 : input[2].charAt(0) - 'A' + 1;

            tree[a].add(b);  // 왼쪽 자식
            tree[a].add(c);  // 오른쪽 자식
        }

        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }

    // 전위 순회
    public static void preOrder(int start) {
        if (start != -18) {
            System.out.print((char) (start + 'A' - 1));
            preOrder(tree[start].get(0)); // 왼쪽
            preOrder(tree[start].get(1)); // 오른쪽
        }
    }

    // 중위 순회
    public static void inOrder(int start) {
        if (start != -18) {
            inOrder(tree[start].get(0)); // 왼쪽
            System.out.print((char) (start + 'A' - 1));
            inOrder(tree[start].get(1)); // 오른쪽
        }
    }

    // 후위 순회
    public static void postOrder(int start) {
        if (start != -18) {
            postOrder(tree[start].get(0)); // 왼쪽
            postOrder(tree[start].get(1)); // 오른쪽
            System.out.print((char) (start + 'A' - 1));
        }
    }
}
