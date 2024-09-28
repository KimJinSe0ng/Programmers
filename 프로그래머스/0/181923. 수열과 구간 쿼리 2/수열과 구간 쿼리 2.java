class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int s = queries[q][0]; 
            int e = queries[q][1];
            int k = queries[q][2]; 
            
            int minValue = Integer.MAX_VALUE;
            
            for (int i = s; i <= e; i++) {
                if (arr[i] > k && arr[i] < minValue) {
                    minValue = arr[i]; 
                }
            }
            
            result[q] = (minValue == Integer.MAX_VALUE) ? -1 : minValue;
        }
        return result;
    }
}