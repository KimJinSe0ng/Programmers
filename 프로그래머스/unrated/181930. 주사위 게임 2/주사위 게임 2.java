class Solution {
    public int solution(int a, int b, int c) {
        if ((a == b) && (b == c) && (c == a)) return (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        if ((a == b) || (b == c) || (c == a)) return (a + b + c) * (a*a + b*b + c*c);
        return (a + b + c);
    }
}