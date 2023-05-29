class Solution {
    public int solution(int n, int k) {
        int food = 12000 * n;
        int drink = 2000 * k;
        int pay = food + drink - (2000 * (n/10));
        return pay;
    }
}