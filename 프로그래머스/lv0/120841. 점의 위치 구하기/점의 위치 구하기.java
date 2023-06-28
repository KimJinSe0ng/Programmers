class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0]; // x좌표
        int y = dot[1]; // y좌표
        if (x > 0) {
            answer = (y > 0) ? 1 : 4;
        } else {
            answer = (y > 0) ? 2 : 3;
        }
        return answer;
    }
}