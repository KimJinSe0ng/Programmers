import java.util.*;

class Solution {
    public String solution(String s) {
        return s.chars() //chars()를 사용해 IntStream으로 변환, chars()는 IntStream이 반환된다. 문자로 구성된 Stream이지만 char도 정수형이기 때문에 IntStream으로 통합해서 다룰 수 있다. CharStream은 없다.
                .boxed() //boxed()로 Stream<Integer>로 변환
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, //append() 대신 appendCodePoint()를 사용해야 문자열에 정수가 들어가지 않고 문자 형식으로 들어간다.
                        StringBuilder::append)
                .toString();
        /**
         * collect()는 Stream의 모든 원소를 하나의 객체로 통합하는 메서드로 3개의 변수를 받을 수 있다.
         * 매개변수1(supplier): 반환할 객체를 생성하는 함수
         * 매개변수2(accumulator): 반환할 객체에 Stream의 원소를 어떻게 누적할지 정의하는 함수
         * 매개변수3(combiner): 반환될 객체가 여러 개 있을 때 어떻게 합치는지 정의하는 함수
         */
    }
}