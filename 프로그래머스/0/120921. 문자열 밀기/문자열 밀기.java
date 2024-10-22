class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        String rotatedA = A;
        for (int i = 1; i <= A.length(); i++) {
            rotatedA = rotatedA.charAt(rotatedA.length() - 1) + rotatedA.substring(0, rotatedA.length() - 1);
            
            if (rotatedA.equals(B)) {
                return i;
            }
        }

        return -1;
    }
}