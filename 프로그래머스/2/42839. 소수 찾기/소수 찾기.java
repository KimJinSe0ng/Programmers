import java.util.*;

class Solution {
    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }

    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) { //numbers는 숫자를 쉽게 제거할 수 있도록 List로 작성
        //종료 조건
        if (isPrime(acc)) primes.add(acc); //acc의 소수 여부에 따라 결과 집합에 포함시킴
        //점화식 구현
        //상태 전이 구현
        for (int i = 0; i < numbers.length; i++) { //numbers의 모든 숫자에 대해 순회하며 상태 전이
            if (isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i]; //전이되는 상태의 acc는 numbers.get(i)가 이어 붙은 acc * 10 + numbers.get(i)가 된다.

            isUsed[i] = true; //이번 재귀에서 사용한 숫자를 사용했다고 체크
            getPrimes(nextAcc, numbers, isUsed, primes); //재귀를 이용해 전이 상태에 대한 부분 문제를 풀고, 그 결과 집합을 현재 풀고 있는 상태의 결과 집합에 합친다.
            isUsed[i] = false; //마지막으로 재귀 호출이 종료되었을 때는 더 이상 해당 숫자를 사용하지 않으므로 다시 false로 체크
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}