import java.util.Scanner;

class WordCountThread extends Thread {
    private final String text;

    public WordCountThread(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        String[] words = text.trim().split("\\s+");
        System.out.println("Total Words: " + words.length);
    }
}


class LongestWordThread extends Thread {
    private final String text;

    public LongestWordThread(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        String[] words = text.trim().split("\\s+");
        String longest = "";

        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }

        System.out.println("Longest Word: " + longest);
    }
}


class LowercaseThread extends Thread {
    private final String text;

    public LowercaseThread(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        System.out.println("Lowercase Feedback: " + text.toLowerCase());
    }
}

public class problem3 {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student feedback:");
        String feedback = sc.nextLine();

        Thread t1 = new WordCountThread(feedback);
        Thread t2 = new LongestWordThread(feedback);
        Thread t3 = new LowercaseThread(feedback);

        t1.start();
        t2.start();
        t3.start();
    }
}
