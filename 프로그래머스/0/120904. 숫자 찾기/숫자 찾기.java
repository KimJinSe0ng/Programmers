class Solution {
    public int solution(int num, int k) {
        String n = Integer.toString(num);
        String K = Integer.toString(k);
        int index = n.indexOf(K);
        return (index == -1) ? -1 : index + 1;
    }
}