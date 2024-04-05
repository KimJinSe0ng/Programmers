/*
참가자들에게 +, -, * 연산 수식 제공, 우선순위 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자 제출
같은 순위의 연산자는 없다.
계산 결과가 음수면 절댓값으로 변환하여 숫자가 가장 클 경우 우승자로 선정
같은 연산자끼리는 앞에 있는 것의 우선순위가 더 높다.
*/

import java.util.*;
import java.util.StringTokenizer;

class Solution {
    private static final String[][] precedences = { //가능한 우선순위
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split(""),
    };

    private long calculate(long lhs, long rhs, String op) { //연산 결과 반환
        return switch (op) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    private long calculate(List<String> tokens, String[] precedence) { //토큰의 리스트로 분리한 수식을 연산자 우선순위를 이용하여 계산
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2; // 연산자를 제거했으므로 2를 빼줘야 올바른 위치로 이동합니다.
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }


    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        //가장 큰 절댓값 찾기
        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}