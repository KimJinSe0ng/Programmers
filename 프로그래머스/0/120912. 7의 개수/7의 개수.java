class Solution {
    public int solution(int[] array) {
        int sum = 0;
        for(int n : array) {
            String str = Integer.toString(n);
            for(char c : str.toCharArray()) {
                if(c == '7') {
                    sum++;
                }
            }
        }
        return sum;
    }
}