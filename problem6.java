import java.util.Scanner;

class VoterIDProcess {
    private int stage = 1;   
    private String applicantName = "";
    private boolean newApplicant = false;

    public synchronized void newApplicant(String name) {
        while (newApplicant) {
            try { wait(); } catch (InterruptedException e) {}
        }
        applicantName = name;
        newApplicant = true;
        stage = 1;  
        notifyAll();
    }

    public synchronized void collect() {
        try {
            while (!newApplicant || stage != 1) {
                wait();
            }
            System.out.println("Collecting details: " + applicantName);
            stage = 2;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void verify() {
        try {
            while (!newApplicant || stage != 2) {
                wait();
            }
            System.out.println("Verifying details: " + applicantName);
            stage = 3;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printID() {
        try {
            while (!newApplicant || stage != 3) {
                wait();
            }
            System.out.println("Printing ID Card for: " + applicantName);
            System.out.println("-----------------------------------------");

            newApplicant = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CollectorThread extends Thread {
    VoterIDProcess process;
    CollectorThread(VoterIDProcess p) { this.process = p; }

    public void run() {
        while (true) process.collect();
    }
}

class VerifierThread extends Thread {
    VoterIDProcess process;
    VerifierThread(VoterIDProcess p) { this.process = p; }

    public void run() {
        while (true) process.verify();
    }
}

class PrinterThread extends Thread {
    VoterIDProcess process;
    PrinterThread(VoterIDProcess p) { this.process = p; }

    public void run() {
        while (true) process.printID();
    }
}


public class problem6 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VoterIDProcess process = new VoterIDProcess();

        new CollectorThread(process).start();
        new VerifierThread(process).start();
        new PrinterThread(process).start();

        while (true) {
            System.out.print("Enter applicant name (or 'exit'): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("System shutting down...");
                break;
            }

            process.newApplicant(name);
        }

        sc.close();
    }
}
