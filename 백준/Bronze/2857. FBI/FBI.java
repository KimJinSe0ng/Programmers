import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reg = "[-]?[F][B][I][0-9]?";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            String line = sc.nextLine();
            Matcher matcher = Pattern.compile(reg).matcher(line);
            if (matcher.find()) {
                stringBuilder.append(i + " ");
            }
        }
        String result = stringBuilder.toString();
        if (!result.isBlank()) {
            System.out.println(result);
        } else {
            System.out.println("HE GOT AWAY!");
        }
    }
}
