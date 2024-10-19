import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        List<String> list = new ArrayList<>();
        for(String s : quiz) {
            String[] temp = s.split(" ");
            int num1 = Integer.parseInt(temp[0]);
            int num2 = Integer.parseInt(temp[2]);
            String op = temp[1];
            int answer = Integer.parseInt(temp[4]);
            if(op.equals("-")) {
                if(num1 - num2 == answer) {
                    list.add("O");
                } else {
                    list.add("X");
                }
            } else {
                if(num1 + num2 == answer) {
                    list.add("O");
                } else {
                    list.add("X");
                }
            }
        }
        return list.toArray(new String[0]);
    }
}