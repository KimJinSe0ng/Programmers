class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < numLog.length; i++) {
            int dist = numLog[i] - numLog[i - 1];
            if(dist == 1) {
                sb.append("w");
            }
            else if (dist == -1) {
                sb.append("s");
            }
            else if (dist == 10) {
                sb.append("d");
            }
            else if (dist == -10) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}