class Solution {
    public int solution(int price) {
        if (price >= 500000) {
            price *= 0.8; // 20% 할인 적용
        } else if (price >= 300000) {
            price *= 0.9; // 10% 할인 적용
        } else if (price >= 100000) {
            price *= 0.95; // 5% 할인 적용
        }
        
        return price;
    }
}