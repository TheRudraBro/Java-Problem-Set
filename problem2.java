import java.util.*;

class Transaction extends Thread {
    private final String name;
    private final String amountStr;

    public Transaction(String name, String amountStr) {
        this.name = name;
        this.amountStr = amountStr;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing: " + name);

            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");

            double fee = amount / 0;
            System.out.println("Success: " + name + " Final amount = " + (amount - fee));
        }

        catch (NumberFormatException e) {
            System.err.println("Number Format Error for " + name + ": " + amountStr);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Invalid Amount for " + name + ": " + e.getMessage());
        }
        catch (ArithmeticException e) {
            System.err.println("Calculation Error for " + name);
        }
        finally {
            System.out.println("Finished: " + name + "\n");
        }
    }
}
public class problem2 {
  public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many transactions? ");
        int n = Integer.parseInt(sc.nextLine());

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter (Name Amount): ");
            String[] p = sc.nextLine().split("\\s+");

            if (p.length != 2) {
                System.out.println("Invalid format. Try again.");
                i--;
                continue;
            }

            Thread t = new Transaction(p[0], p[1]);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) t.join();

        System.out.println("All transactions completed.");
    }
}