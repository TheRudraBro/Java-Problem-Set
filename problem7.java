import java.util.Scanner;

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}
public class problem7 {
   public static void registerVoter(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("Applicant is NOT eligible. Age " + age + " is below 18.");
        }
        System.out.println("Applicant is eligible for voting. Registration successful!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter applicant age (or type -1 to exit): ");
            int age = sc.nextInt();

            if (age == -1) {
                System.out.println("System shutting down...");
                break;
            }

            try {
                registerVoter(age);
            } catch (UnderAgeException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("--------------------------------------");
        }

        sc.close();
    }  
}
