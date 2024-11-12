import java.util.Arrays;
import java.util.Scanner;

public class heap {
    private int[] heap;
    private int size;
    private int capacity;

    public heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) 
    {
        return (index - 1) / 2;
    }

  
    private int leftChild(int index) 
    {
        return 2 * index + 1;
    }

    
    private int rightChild(int index) 
    {
        return 2 * index + 2;
    }

    
    public void insert(int value) 
    {
        if (size == capacity)
        {
            throw new RuntimeException("Heap is full");
        }

        heap[size] = value;
        size++;
        HeapUp(size - 1);
    }

    private void HeapUp(int index)
     {
        int parentIndex = parent(index);
        if (index > 0 && heap[index] < heap[parentIndex]) 
        {
            swap(index, parentIndex);
            HeapUp(parentIndex);
        }
    }

    
    public int extractMin() 
    {
        if (size == 0) 
        {
            throw new RuntimeException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        HeapDown(0);
        return min;
    }

   
    private void HeapDown(int index)
     {
        int smallest = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (leftIndex < size && heap[leftIndex] < heap[smallest]) 
        {
            smallest = leftIndex;
        }

        if (rightIndex < size && heap[rightIndex] < heap[smallest]) 
        {
            smallest = rightIndex;
        }

        if (smallest != index) 
        {
            swap(index, smallest);
            HeapDown(smallest);
        }
    }

   
    private void swap(int i, int j) 
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    
    public int size() 
    {
        return size;
    }

   
    public boolean isEmpty() 
    {
        return size == 0;
    }

   
    public int getMin() 
    {
        if (size == 0) 
        {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    
    public void printHeap() 
    {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial capacity of the heap: ");
        int capacity = scanner.nextInt();
        heap heap = new heap(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an element");
            System.out.println("2. Extract the minimum element");
            System.out.println("3. Print the heap");
            System.out.println("4. Get the minimum element");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    try 
                    {
                        heap.insert(value);
                    } catch (RuntimeException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        int min = heap.extractMin();
                        System.out.println("Extracted min: " + min);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    heap.printHeap();
                    break;

                case 4:
                    try {
                        int min = heap.getMin();
                        System.out.println("Current min: " + min);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
