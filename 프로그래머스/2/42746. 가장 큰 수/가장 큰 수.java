import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining("")) //단순히 문자열로 구성된 Stream을 하나의 문자열로 구성하는 것은 joining()을 사용하면 된다.
                .replaceAll("^0+", "0"); //^는 문자열의 시작, +는 1회 이상 반복 -> 문자열의 시작 부분에서 0이 반복해서 나타난다면 0 하나로 대체하라
    }
}