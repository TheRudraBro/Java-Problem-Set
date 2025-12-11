
class TrafficController {
    public synchronized void requestGreen(String intersection) {
        System.out.println(intersection + " -> GREEN allowed");
    }
    public synchronized void releaseGreen(String intersection) {
        System.out.println(intersection + " -> GREEN finished");
    }
}

class Intersection extends Thread {
    private final String name;
    private final TrafficController controller;
    private final int greenTime;

    public Intersection(String name, TrafficController controller, int greenTime, int priority) {
        this.name = name;
        this.controller = controller;
        this.greenTime = greenTime;
        setPriority(priority); 
    }

    @Override
    public void run() {
        try {
            while (true) {

                System.out.println(name + ": RED");
                Thread.sleep(2000);

                controller.requestGreen(name);
                System.out.println(name + ": GREEN");
                Thread.sleep(greenTime); 

                controller.releaseGreen(name);

                System.out.println(name + ": YELLOW");
                Thread.sleep(1000);

                System.out.println("--------------------------");
            }

        } catch (InterruptedException e) {
            System.out.println(name + " thread interrupted.");
        }
    }
}

public class Testing {
  public static void main(String[] args) {

        TrafficController controller = new TrafficController();

        Intersection mainRoad = new Intersection(
                "Main Road Intersection",
                controller,
                4000,  
                Thread.MAX_PRIORITY
        );

        Intersection sideRoad1 = new Intersection(
                "Side Road 1",
                controller,
                2000,
                Thread.NORM_PRIORITY
        );

        Intersection sideRoad2 = new Intersection(
                "Side Road 2",
                controller,
                2000,
                Thread.NORM_PRIORITY
        );

        mainRoad.start();
        sideRoad1.start();
        sideRoad2.start();
    }
   
}