import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        System.out.println(findArithmeticMean(numbers));
        System.out.println(findMedianValue(numbers));
        System.out.println(findModeByArray(numbers));
        System.out.println(findRange(numbers));
    }

    private static int findArithmeticMean(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (int) Math.round(sum / N);
    }

    private static int findMedianValue(int[] numbers) {
        return numbers[numbers.length / 2];
    }

    private static int findModeByMap(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        // 빈도 리스트 생성 및 정렬
        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey() - b.getKey();
        });

        // 최빈값 중 두 번째로 작은 값 반환
        if (frequencyList.size() > 1 && frequencyList.get(0).getValue().equals(frequencyList.get(1).getValue())) {
            return frequencyList.get(1).getKey(); // 빈도가 같으면 두 번째 값 반환
        }
        return frequencyList.get(0).getKey(); // 최빈값 반환
    }

    private static int findModeByArray(int[] numbers) {
        int[] frequency = new int[8001]; // -4000 ~ 4000을 표현 (인덱스 0 ~ 8000)
        int maxFrequency = 0;

        // 빈도 계산
        for (int number : numbers) {
            frequency[number + 4000]++;
            maxFrequency = Math.max(maxFrequency, frequency[number + 4000]);
        }

        // 최빈값 찾기
        int mode = Integer.MAX_VALUE;
        boolean isSecond = false;

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == maxFrequency) {
                if (!isSecond) {
                    mode = i - 4000;
                    isSecond = true; // 첫 번째 최빈값을 발견
                } else {
                    mode = i - 4000; // 두 번째 최빈값을 발견
                    break;
                }
            }
        }
        return mode;
    }


    private static int findRange(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }
}
