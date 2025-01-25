import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> a[];
    static boolean visited[];
    static int n;
    static int m;
    static int s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        a = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        visited = new boolean[n + 1];
        dfs(s);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(s);
        System.out.println();
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : a[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for (int i : a[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
