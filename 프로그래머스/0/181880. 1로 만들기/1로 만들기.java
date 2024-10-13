class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i = 0; i < num_list.length; i++) {
            answer += calculate(num_list[i]);
        }
        return answer;
    }
    
    private int calculate(int num) {
        int cnt = 0;
        while(num > 1) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num = (num - 1) / 2;
            }
            cnt++;
        }
        return cnt;
    }
}