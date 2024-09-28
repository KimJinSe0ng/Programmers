class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        String str_ab = sb.append(a).append(b).toString();
        sb.setLength(0);
        String str_ba = sb.append(b).append(a).toString();
        int ab = Integer.parseInt(str_ab);
        int ba = Integer.parseInt(str_ba);
        return (ab > ba) ? ab : ba;
    }
}