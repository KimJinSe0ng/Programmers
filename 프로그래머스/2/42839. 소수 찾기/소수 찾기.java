import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        permute("", numbers, uniqueNumbers);

        int count = 0;
        for (int num : uniqueNumbers) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }
    
    private void permute(String prefix, String remaining, Set<Integer> uniqueNumbers) {
        System.out.println(remaining);
        if (!prefix.isEmpty()) {
            uniqueNumbers.add(Integer.parseInt(prefix));
        }
        
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), 
                    uniqueNumbers);
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}