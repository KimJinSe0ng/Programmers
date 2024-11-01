class Solution {
    public int[] solution(int brown, int yellow) {
        //갈색 가로 = 노랑 가로
        //갈색 세로 = 노랑 세로 + 2
        //갈색 개수 : 노랑 가로 * 2 +  (노랑 세로 + 2) * 2
        int[] answer = new int[2];
        for(int x = 1; x <= yellow; x++) { //노랑의 가로:x, 노랑의 세로:y
            int y = yellow / x;
            if(x < y) {
                continue;
            }
            if(x * 2 + (y + 2) * 2 == brown) {
                answer[0] = x + 2;
                answer[1] = y + 2;
                break;
            }
        }
        return answer;
    }
}