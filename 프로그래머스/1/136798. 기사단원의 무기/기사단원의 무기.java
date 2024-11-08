class Solution {
    public int solution(int number, int limit, int power) {
        /*
            기사는 자신의 번호 약수 개수에 해당하는 공격력을 가진 무기를 구매한다.
            단, 이웃나라에 의해 공격력 제한 수치를 정하고, 제한 수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는
            기관에서 정해준 공격력을 가진 무기를 구매해야 한다.
            무기를 만들 때 공격력 1당 1kg 철이 필요.
            필요한 철의 무게 계산.
        */
        
        //1.약수 개수 구하기
        //2.제한 수치를 넘는지 검증
        //2.1.1.제한 수치를 넘는 개수 카운트
        //2.1.2.카운트 * power
        //2.2.안 넘으면 약수 개수대로 더함
        int[] cd = new int[number + 1];
        int over = 0;
        int sum = 0;

        for(int i = 1; i <= number; i++) {
            cd[i] = calculateCD(i);
            
            if(cd[i] > limit) {
                over++;
                continue;
            }
            
            sum += cd[i];
        }
        
        sum += power * over;
        
        return sum;
    }
    
    private int calculateCD(int num) {
        int count = 0;
        
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (i != num / i) {
                    count++;
                }
            }
        }
        
        return count;
    }
}