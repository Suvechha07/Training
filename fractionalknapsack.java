import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
class Item {
    int weight;
    int value;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
public class fractionalknapsack 
{
    public static double getMaxValue(int capacity, Item[] items) 
    {
        Arrays.sort(items, new Comparator<Item>() 
        {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });
        double totval = 0.0;
        for (Item item : items) 
        {
            int cwt = item.weight;
            int currVal = item.value;
            if (capacity - cwt >= 0) 
            {
                capacity -= cwt;
                totval += currVal;
            } 
            else 
            {
                double fraction = ((double) capacity / cwt);
                totval += (currVal * fraction);
                capacity = 0;
                break;
            }
        }
        return totval;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value for item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();
        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value in the knapsack = " + maxValue);
        scanner.close();
    }
}
/*int largest = i;
int left = 2 * i + 1;
int right = 2 * i + 2;

if (left < n && arr[left].profit_weight_ratio > arr[largest].profit_weight_ratio) 
{
    largest = left;
}

if (right < n && arr[right].profit_weight_ratio > arr[largest].profit_weight_ratio) 
{
    largest = right;
}

if (largest != i) 
{
    Item temp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = temp;

    heapify(arr, n, largest);
}
}*/