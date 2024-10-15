import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
        // Stack<String> stack = new Stack<>();
        // String[] arr = s.split("");
        // for(String S : arr) {
        //     if(S.equals("(")) {
        //         stack.push("(");
        //     } else {
        //         if(stack.isEmpty()) {
        //             return false;
        //         }
        //         stack.pop();
        //     }
        // }
        // if(!stack.isEmpty()) {
        //     return false;
        // }
        // return true;
    }
}