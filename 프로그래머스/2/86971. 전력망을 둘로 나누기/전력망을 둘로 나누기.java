import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        int minDifference = n;
        
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            int nodeCount1 = bfs(v1, v2, graph, n);
            int nodeCount2 = n - nodeCount1;
            
            minDifference = Math.min(minDifference, Math.abs(nodeCount1 - nodeCount2));
        }
        
        return minDifference;
    }
    
    //네트워크 노드 개수 구하기
    private int bfs(int start, int ignore, List<List<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int neighbor : graph.get(now)) {
                if(neighbor == ignore || visited[neighbor]) continue;
                q.add(neighbor);
                visited[neighbor] = true;
                count++;
            }
        }
        
        return count;
    }
}