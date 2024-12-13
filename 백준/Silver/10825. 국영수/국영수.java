import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Student> students = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int languageScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());
            students.add(new Student(name, languageScore, englishScore, mathScore));
        }

        Collections.sort(students, (a, b) -> {
            if (b.languageScore != a.languageScore) {
                return b.languageScore - a.languageScore;
            }
            if (a.englishScore != b.englishScore) {
                return a.englishScore - b.englishScore;
            }
            if (b.mathScore != a.mathScore) {
                return b.mathScore - a.mathScore;
            }
            return a.name.compareTo(b.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }

    private static class Student {
        public String name;
        public int languageScore;
        public int englishScore;
        public int mathScore;

        public Student(String name, int languageScore, int englishScore, int mathScore) {
            this.name = name;
            this.languageScore = languageScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }
    }
}
