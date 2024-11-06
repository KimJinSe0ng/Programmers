class Solution {
    public int solution(int a, int b, int n) {
        int totalCola = 0;

        while (n >= a) {
            int newCola = (n / a) * b;   // 새로 얻는 콜라의 개수
            totalCola += newCola;        // 총 콜라 개수에 추가
            n = (n % a) + newCola;       // 남은 빈 병과 새로 얻은 빈 병의 합
        }

        return totalCola;
    }
}