import java.util.Scanner;

// Define the SYMBOL class
class SYMBOL {
    char alphabet;
    int frequency;

    SYMBOL(char alphabet, int frequency) {
        this.alphabet = alphabet;
        this.frequency = frequency;
    }
}


class Node {
    SYMBOL symbol;
    Node left, right;

    Node(SYMBOL symbol) {
        this.symbol = symbol;
        this.left = null;
        this.right = null;
    }

    Node(Node left, Node right) {
        this.symbol = new SYMBOL('\0', left.symbol.frequency + right.symbol.frequency);
        this.left = left;
        this.right = right;
    }
}


class MinPriorityQueue {
    private Node[] heap;
    int size;

    MinPriorityQueue(int capacity) {
        heap = new Node[capacity];
        size = 0;
    }

    void insert(Node node) {
        heap[size] = node;
        size++;
        heapifyUp(size - 1);
    }

    Node extractMin() {
        if (size == 0) {
            return null;
        }
        Node minNode = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return minNode;
    }

    boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index].symbol.frequency < heap[parentIndex].symbol.frequency) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left].symbol.frequency < heap[smallest].symbol.frequency) {
            smallest = left;
        }
        if (right < size && heap[right].symbol.frequency < heap[smallest].symbol.frequency) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


public class HuffmanCoding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of distinct alphabets: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter the alphabets: ");
        char[] alphabets = new char[n];
        for (int i = 0; i < n; i++) {
            alphabets[i] = scanner.next().charAt(0);
        }

       
        System.out.print("Enter its frequencies: ");
        int[] frequencies = new int[n];
        for (int i = 0; i < n; i++) {
            frequencies[i] = scanner.nextInt();
        }

      
        SYMBOL[] symbols = new SYMBOL[n];
        for (int i = 0; i < n; i++) {
            symbols[i] = new SYMBOL(alphabets[i], frequencies[i]);
        }

       
        MinPriorityQueue minHeap = new MinPriorityQueue(n);
        for (SYMBOL symbol : symbols) {
            minHeap.insert(new Node(symbol));
        }

     
        while (minHeap.size > 1) {
            Node left = minHeap.extractMin();
            Node right = minHeap.extractMin();
            Node parent = new Node(left, right);
            minHeap.insert(parent);
        }

       
        Node root = minHeap.extractMin();

      
        System.out.print("In-order traversal of the tree (Huffman): ");
        inOrderTraversal(root);
        System.out.println();
    }

    private static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            if (root.symbol.alphabet != '\0') {
                System.out.print(root.symbol.alphabet + " ");
            }
            inOrderTraversal(root.right);
        }
    }
}
