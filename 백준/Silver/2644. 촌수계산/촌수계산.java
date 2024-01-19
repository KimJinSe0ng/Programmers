import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int loop = Integer.parseInt(br.readLine());

        List<List<Integer>> family = new ArrayList<>();
        for(int i = 0; i < num + 1 ; i ++) {
            family.add(new ArrayList<>());
        }

        for (int i=0; i<loop; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family.get(a).add(b);
            family.get(b).add(a);
        }
        int[] visited = new int[num+1];
        bfs(visited, start, family);
        System.out.println(visited[end] == 0 ? -1 : visited[end]);
    }

    private static void bfs(int[] visited, int start, List<List<Integer>> list){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;

        while(!queue.isEmpty()){
            Integer current = queue.poll();
            int current_dist = visited[current];

            for(Integer next: list.get(current)){
                if (visited[next] == 0 || visited[next] >= current_dist + 1) {
                    queue.add(next);
                    visited[next] = current_dist + 1;
                }
            }
        }
    }
}
