class Solution {
    public int solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        // 2부터 n까지를 일단 모두 소수로 간주
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스의 체 알고리즘을 사용하여 소수 판별
        for (int i = 2; i * i <= n; i++) {
            System.out.println(i);
            if (isPrime[i]) { // i가 소수라면
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // i의 배수들은 소수가 아님
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}