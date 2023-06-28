class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int evenNum = 0;
        int oddNum = 0;
        for(int num: num_list) {
            if (num % 2 == 0) evenNum += 1;
            else oddNum += 1;
        }
        answer[0] = evenNum;
        answer[1] = oddNum;
        return answer;
    }
}