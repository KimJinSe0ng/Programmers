class Solution {
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        recur(k, dungeons, visited, 0);
        return answer;
    }
    
    private void recur(int remain, int[][] dungeons, boolean[] visited, int ans) {
        answer = Math.max(answer, ans);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || remain < dungeons[i][0]) {
                continue;
            }
            
            visited[i] = true;
            recur(remain - dungeons[i][1], dungeons, visited, ans + 1);
            visited[i] = false;
        }
    }
}