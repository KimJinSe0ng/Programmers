class Solution {
    public int solution(int a, int b) {
        String strA = "" + a + b;
        int A = Integer.parseInt(strA);
        int B = 2 * a * b;
        int answer = (A >= B) ? A : B;
        return answer;
    }
}