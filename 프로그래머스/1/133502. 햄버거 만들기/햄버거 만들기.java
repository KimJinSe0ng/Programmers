class Solution {
    private static final String BURGER = "1231";
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int ing : ingredient) {
            sb.append(ing); 

            if (sb.length() >= 4 && sb.substring(sb.length() - 4).equals(BURGER)) {
                sb.delete(sb.length() - 4, sb.length()); 
                count++;
            }
        }

        return count;
    }
}