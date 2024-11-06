class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        for(int i = 1; i <= count; i++) {
            total += (long) (price * i);
        }
        
        System.out.println(total - money);
        long answer = total - money;

        return (answer > 0) ? answer : 0;
    }
}