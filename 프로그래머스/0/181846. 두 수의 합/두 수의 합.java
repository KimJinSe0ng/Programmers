import java.math.*;

class Solution {
    public String solution(String a, String b) {
        // 문자열 a와 b를 BigInteger로 변환
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        
        // 두 BigInteger의 합을 구한 후, 다시 문자열로 변환하여 반환
        BigInteger sum = numA.add(numB);
        return sum.toString();
    }
}