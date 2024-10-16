class Solution {
    public int solution(int n) {
        int i = 1;
        boolean isFind = false;
        while(!isFind) {
            int answer = factorial(i);
            if(answer > n) {
                return i - 1;
            }
            if(answer == n) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    private int factorial(int num) {
        if(num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}