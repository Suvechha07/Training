import java.util.*;

class Person 
{
    int id;
    String name;
    int age;
    int height;
    int weight; 

    Person(int id, String name, int age, int height, int weight) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}

public class heapsort 
{
    private static PriorityQueue<Person> minHeap;
    private static PriorityQueue<Person> maxHeap;
    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMAIN MENU (HEAP)");
            System.out.println("1. Read Data");
            System.out.println("2. Create a Min-heap based on the age");
            System.out.println("3. Create a Max-heap based on the weight");
            System.out.println("4. Display weight of the youngest person");
            System.out.println("5. Insert a new person into the Min-heap");
            System.out.println("6. Delete the oldest person");
            System.out.println("7. Exit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    readData(scanner);
                    break;
                case 2:
                    createMinHeap();
                    break;
                case 3:
                    createMaxHeap();
                    break;
                case 4:
                    displayYoungestWeight();
                    break;
                case 5:
                    insertIntoMinHeap(scanner);
                    break;
                case 6:
                    deleteOldestPerson();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void readData(Scanner scanner) {
        personList.clear();
        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Height: ");
            int height = scanner.nextInt();

            System.out.print("Weight (pounds): ");
            int weight = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            personList.add(new Person(id, name, age, height, weight));
        }
    }

    private static void createMinHeap() {
        minHeap = new PriorityQueue<>(new PersonAgeComparator());
        minHeap.addAll(personList);
        System.out.println("Min-Heap based on age created.");
    }

    private static void createMaxHeap() {
        maxHeap = new PriorityQueue<>(new PersonWeightComparator());
        maxHeap.addAll(personList);
        System.out.println("Max-Heap based on weight created.");
    }

    private static void displayYoungestWeight() {
        if (minHeap == null || minHeap.isEmpty()) {
            System.out.println("Min-Heap is not created or empty.");
            return;
        }

        Person youngest = minHeap.peek();
        double weightKg = youngest.weight * 0.453592; // Convert pounds to kg
        System.out.printf("Weight of youngest student: %.2f kg\n", weightKg);
    }

    private static void insertIntoMinHeap(Scanner scanner) {
        if (minHeap == null) {
            System.out.println("Min-Heap is not created.");
            return;
        }

        System.out.println("Enter details for the new student:");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Height: ");
        int height = scanner.nextInt();

        System.out.print("Weight (pounds): ");
        int weight = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Person newPerson = new Person(id, name, age, height, weight);
        minHeap.add(newPerson);
        System.out.println("New person inserted into Min-Heap.");
    }

    private static void deleteOldestPerson() {
        if (minHeap == null || minHeap.isEmpty()) {
            System.out.println("Min-Heap is not created or empty.");
            return;
        }

        Person oldest = minHeap.peek(); // Get the oldest person (by min age)
        personList.remove(oldest);
        minHeap.poll(); // Remove from heap
        System.out.println("Oldest person removed from Min-Heap.");
    }
}
