interface Motor {
    int capacity = 100;

    void run();

    void consume();
}

class WashingMachine implements Motor {
    public void run() {
        System.out.println("Washing machine is running");
    }

    public void consume() {
        System.out.println("Washing machine is consuming power");
    }
}

public class capacity {
    public static void main(String args[]) {
        WashingMachine ob = new WashingMachine();
        ob.consume();
        ob.run();
        System.out.println("Capacity = " + Motor.capacity);
    }
}