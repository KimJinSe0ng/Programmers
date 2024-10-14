class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = my_string.split("");
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i].repeat(n));
        }
        return sb.toString();
    }
}