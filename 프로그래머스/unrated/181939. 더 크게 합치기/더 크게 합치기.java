class Solution {
    public int solution(int a, int b) {
        String strA = (Integer.toString(a) + b);
        String strB = Integer.toString(b) + a;
        int A = Integer.parseInt(strA);
        int B = Integer.parseInt(strB);
        if(A >= B) return A;
        else return B;
    }
}