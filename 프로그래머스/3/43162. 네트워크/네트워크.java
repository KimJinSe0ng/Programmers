import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int computer, int[][] computers, boolean[] visited) {
        visited[computer] = true;
        for (int next = 0; next < computers[computer].length; next++) {
            if (computers[computer][next] == 1 && !visited[next]) {
                dfs(next, computers, visited);
            }
        }
    }
}