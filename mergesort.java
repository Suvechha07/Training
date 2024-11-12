public class mergesort {

    private static int comparisonCount = 0;

    public static void main(String[] args) {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        boolean running = true;

        while (running) {
            System.out.println("MAIN MENU (MERGE SORT)");
            System.out.println("1. Ascending Data");
            System.out.println("2. Descending Data");
            System.out.println("3. Random Data");
            System.out.println("4. ERROR (EXIT)");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(reader.readLine());
                
                switch (choice) {
                    case 1:
                        sortArray(generateAscendingArray());
                        break;
                    case 2:
                        sortArray(generateDescendingArray());
                        break;
                    case 3:
                        sortArray(generateRandomArray());
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private static void sortArray(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);

        System.out.print("Original Array: ");
        printArray(array);

        long startTime = System.nanoTime();
        mergeSort(arrayCopy);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.print("Sorted Array: ");
        printArray(arrayCopy);
        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("Number of Comparisons: " + comparisonCount);

        // Reset comparison count for next sort
        comparisonCount = 0;
    }

    private static void mergeSort(int[] array) 
    {
        if (array.length < 2) 
        {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Copy elements to left and right arrays
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            comparisonCount++;
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    private static int[] generateAscendingArray() {
        int size = 10; // Size of the array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private static int[] generateDescendingArray() {
        int size = 10; // Size of the array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    private static int[] generateRandomArray() {
        int size = 10; // Size of the array
        int[] array = new int[size];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Random number between 0 and 99
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
