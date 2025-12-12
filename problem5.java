import java.util.*;

class Voter implements Comparable<Voter> {
    String name;
    int age;
    boolean disabled;
    boolean pregnant;

    public Voter(String name, int age, boolean disabled, boolean pregnant) {
        this.name = name;
        this.age = age;
        this.disabled = disabled;
        this.pregnant = pregnant;
    }

    @Override
    public int compareTo(Voter v) {
   
        if (this.age >= 60 && v.age < 60) return -1;
        if (v.age >= 60 && this.age < 60) return 1;

      
        if (this.disabled && !v.disabled) return -1;
        if (v.disabled && !this.disabled) return 1;

        if (this.pregnant && !v.pregnant) return -1;
        if (v.pregnant && !this.pregnant) return 1;

        return 0;
    }

    @Override
    public String toString() {
        return name + " (Age:" + age + 
               ", Disabled:" + disabled + 
               ", Pregnant:" + pregnant + ")";
    }
}


public class problem5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PriorityQueue<Voter> queue = new PriorityQueue<>();

        System.out.print("How many voters will arrive? ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter voter " + i + " details:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Disabled (true/false): ");
            boolean disabled = sc.nextBoolean();

            System.out.print("Pregnant (true/false): ");
            boolean pregnant = sc.nextBoolean();
            sc.nextLine();

            queue.add(new Voter(name, age, disabled, pregnant));
        }

        System.out.println("\n=== Voting Order ===");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
