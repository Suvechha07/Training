import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Method to get the parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Method to get the left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Method to get the right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Method to insert a new element
    public void insert(int value) {
        if (size == capacity) {
            throw new RuntimeException("Heap is full");
        }

        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // Method to heapify up
    private void heapifyUp(int index) {
        int parentIndex = parent(index);
        if (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    // Method to remove the minimum element (root of the heap)
    public int extractMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    // Method to heapify down
    private void heapifyDown(int index) {
        int smallest = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (leftIndex < size && heap[leftIndex] < heap[smallest]) {
            smallest = leftIndex;
        }

        if (rightIndex < size && heap[rightIndex] < heap[smallest]) {
            smallest = rightIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to get the size of the heap
    public int size() {
        return size;
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the minimum element (root of the heap) without removing it
    public int getMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    // Method to print the heap
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    // Method to print sorted elements of the heap
    public void printSorted() {
        // Extract all elements and store in a list
        List<Integer> sortedList = new ArrayList<>();
        while (!isEmpty()) {
            sortedList.add(extractMin());
        }

        // Print the sorted list
        System.out.println("Sorted elements: " + sortedList);
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial capacity of the heap: ");
        int capacity = scanner.nextInt();
        MinHeap minHeap = new MinHeap(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an element");
            System.out.println("2. Extract the minimum element");
            System.out.println("3. Print the heap");
            System.out.println("4. Get the minimum element");
            System.out.println("5. Print sorted elements");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    try {
                        minHeap.insert(value);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        int min = minHeap.extractMin();
                        System.out.println("Extracted min: " + min);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    minHeap.printHeap();
                    break;

                case 4:
                    try {
                        int min = minHeap.getMin();
                        System.out.println("Current min: " + min);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    minHeap.printSorted();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
