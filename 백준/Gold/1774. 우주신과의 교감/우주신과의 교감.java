import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int s;
    int e;
    double weight;
	
    public Edge(int s, int e, double weight) {
        this.s = s;
        this.e = e;
        this.weight = weight;
    }
	
    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken()); // 우주신들의 개수
        int M = Integer.parseInt(st.nextToken()); // 연결된 신들과의 통로의 개수
		
        int[][] god = new int[N + 1][2]; // 우주신의 좌표 저장
		
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
			
            god[i][0] = Integer.parseInt(st.nextToken());
            god[i][1] = Integer.parseInt(st.nextToken());
        }
		
        parent = new int[N + 1];
		
        // 부모를 자기 자신으로 초기화
        for (int i = 1; i <= N ; i++) {
            parent[i] = i;
        }
		
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
			
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
		
            union(s, e); // 이미 연결된 통로는 union을 통해 합침
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
		
        // 연결할 수 있는 모든 통로를 큐에 추가
        for (int i = 1; i < N; i++) {			
            for (int j = i + 1; j < N + 1; j++) {
                int x1 = god[i][0];
                int y1 = god[i][1];
                int x2 = god[j][0];
                int y2 = god[j][1];
				
                double weight = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				
                pq.add(new Edge(i, j, weight));
            }
        }

        double result = 0;
		
        // 크루스칼 알고리즘 이용
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
			
            // 통로의 시작점과 끝점의 그룹을 합침(최상위 노드가 다를 경우)
            if (union(edge.s, edge.e)) {
                result += edge.weight; // 가중치를 더함
            }
        }
		
        System.out.println(String.format("%.2f", result));
		
    }
	
    // x가 속하는 부모 노드(최상위 노드)를 찾음
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        else {
            return parent[x] = find(parent[x]);
        }
    }
	
    // 두 개의 노드가 속한 집합을 합침(연결함)
    public static boolean union(int x, int y) {
        // 통로의 시작점과 끝점의 최상위 노드를 찾음
        x = find(x);
        y = find(y);
		
        // 최상위 노드가 같지 않을 경우 union
        if (x != y) {
            parent[x] = y;
            return true;
        }
		
        return false;
    }

}