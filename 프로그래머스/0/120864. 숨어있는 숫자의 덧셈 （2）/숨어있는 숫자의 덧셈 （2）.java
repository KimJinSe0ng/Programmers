public class Solution {
    public int solution(String my_string) {
        int sum = 0;
        String num = "";

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);

            if (Character.isDigit(ch)) {
                num += ch;
            } else {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }
        }

        if (!num.isEmpty()) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
