import java.util.*;
import java.io.*;
class Main {
        static ArrayList<Integer>[] A; //인접리스트
        static boolean visited[];
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //정점
            int m = Integer.parseInt(st.nextToken()); //간선
            A = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i < n + 1; i++) { //인접리스트 초기화
                A[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken()); //양방향 간선이므로 양쪽에 간선을 더하기
                int node2 = Integer.parseInt(st.nextToken());
                A[node1].add(node2);
                A[node2].add(node1);
            }

            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) { //방문하지 않은 노드가 없을 때까지 반복
                    count++;
                    DFS(i);
                }
            }
            System.out.println(count);
        }

        static void DFS(int v) {
            if (visited[v]) {
                return;
            }
            visited[v] = true;
            for (int i : A[v]) {
                if (visited[i] == false) {
                    DFS(i);
                }
            }
        }
    }