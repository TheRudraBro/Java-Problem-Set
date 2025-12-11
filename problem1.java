import java.util.Scanner;
public class problem1 {
    public static String formatName(String name) {
        // Trim and convert to lowercase
        name = name.trim().toLowerCase();
        String[] words = name.split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (String w : words) {
            if (!w.isEmpty()) {
                formattedName.append(Character.toUpperCase(w.charAt(0)))
                             .append(w.substring(1))
                             .append(" ");
            }
        }

        return formattedName.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("");
        String inputName = sc.nextLine();

        String cleanedName = formatName(inputName);
        System.out.println(cleanedName);
    }
}