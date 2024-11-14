class Solution {
    public int[] solution(int n) {
        int[][] t = new int[n][n];
        
        int x = 0;
        int y = 0;
        int v = 1;
        
        while(true) {
            //1.밑으로 이동
            while(true) {
                t[y][x] = v++;
                if(y + 1 == n || t[y + 1][x] != 0) break;
                y += 1;
            }
            if(x + 1 == n || t[y][x + 1] != 0) break;
            x += 1;
            
            //2.오른쪽으로 이동
            while(true) {
                t[y][x] = v++;
                if(x + 1 == n || t[y][x + 1] != 0) break;
                x += 1;
            }
            if(t[y - 1][x - 1] != 0) break;
            x -= 1;
            y -= 1;
            
            //3.대각선으로 이동
            while(true) {
                t[y][x] = v++;
                if(t[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if(y + 1 == n || t[y + 1][x] != 0) break;
            y += 1;
        }
        
        int[] result = new int[v - 1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = t[i][j];
            }
        }
        
        return result;
    }
}