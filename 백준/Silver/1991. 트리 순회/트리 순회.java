import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = input[0].charAt(0) - 'A' + 1;
            int b = input[1].charAt(0) - 'A' + 1;
            int c = input[2].charAt(0) - 'A' + 1;

            tree.get(a).add(b);
            tree.get(a).add(c);
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
            System.out.print((char)(start + 'A' - 1));
            preOrder(tree.get(start).get(0));
            preOrder(tree.get(start).get(1));
        }
    }

    // 중위 순회
    public static void inOrder(int start) {
        if (start != -18) {
            inOrder(tree.get(start).get(0));
            System.out.print((char)(start + 'A' - 1));
            inOrder(tree.get(start).get(1));
        }
    }

    // 후위 순회
    public static void postOrder(int start) {
        if (start != -18) {
            postOrder(tree.get(start).get(0));
            postOrder(tree.get(start).get(1));
            System.out.print((char)(start + 'A' - 1));
        }
    }
}
