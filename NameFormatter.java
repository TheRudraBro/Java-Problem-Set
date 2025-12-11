public class NameFormatter {

    public static String formatName(String name) {
        // Step 1: Trim leading and trailing spaces
        name = name.trim().toLowerCase();

        // Step 2: Split the string into words
        String[] words = name.split("\\s+");

        StringBuilder formattedName = new StringBuilder();

        // Step 3: Capitalize first letter of each word
        for (String word : words) {
            if (!word.isEmpty()) {
                formattedName.append(Character.toUpperCase(word.charAt(0)))
                             .append(word.substring(1))
                             .append(" ");
            }
        }

        // Step 4: Return final cleaned name (trim extra last space)
        return formattedName.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(formatName(" rAhUL shArmA "));
        System.out.println(formatName("NEHA singh"));
        System.out.println(formatName(" ajAY VERMA"));
    }
}
