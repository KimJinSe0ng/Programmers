class Solution {
    public static int solution(String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step); // 앞에서부터 step만큼의 문자열 추출
            int cnt = 1;

            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j += step) {
                // step 만큼의 다음 문자열 추출
                String sub = s.substring(j, Math.min(j + step, s.length()));

                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                if (prev.equals(sub)) {
                    cnt += 1;
                } else {
                    // 압축 문자열에 추가
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    prev = sub; // prev를 현재 문자열로 갱신
                    cnt = 1;    // count 초기화
                }
            }

            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2) ? cnt + prev : prev;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}