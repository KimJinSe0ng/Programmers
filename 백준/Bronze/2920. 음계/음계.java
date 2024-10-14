import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.nextLine().split(" ");
        int[] notes = new int[8];
        
        for (int i = 0; i < 8; i++) {
            notes[i] = Integer.parseInt(input[i]);
        }

        if (isAscending(notes)) {
            System.out.println("ascending");
        } else if (isDescending(notes)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

    private static boolean isAscending(int[] notes) {
        for (int i = 0; i < 8; i++) {
            if (notes[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDescending(int[] notes) {
        for (int i = 0; i < 8; i++) {
            if (notes[i] != 8 - i) {
                return false;
            }
        }
        return true;
    }
}
