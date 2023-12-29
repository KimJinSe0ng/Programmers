import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point
{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Main {
    static int N;
    static List<List<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0)
        {
            N = Integer.parseInt(br.readLine());

            Point [] nodes = new Point[N+2];
            for(int i = 0; i < N+2; ++i)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                nodes[i] = new Point(x,y);
            }

            map = new ArrayList<>();
            for(int i = 0; i < N+2; ++i) map.add(new ArrayList<>());

            for(int i = 0; i < N+1; ++i)
            {
                for(int j = i+1; j < N+2; ++j)
                {
                    int diff = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
                    if(diff <= 1000)
                    {
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }
    static String bfs()
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean [] visited = new boolean[N+2];
        visited[0] = true;

        while(!q.isEmpty())
        {
            int cur = q.poll();

            if(cur == N+1) return "happy";
            for(int i : map.get(cur))
            {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        return "sad";
    }
}