import java.util.Scanner;

class Item 
{
    int item_id;
    double item_profit;
    double item_weight;
    double profit_weight_ratio;

    Item(int id, double profit, double weight) 
    {
        this.item_id = id;
        this.item_profit = profit;
        this.item_weight = weight;
        this.profit_weight_ratio = profit / weight;
    }
}

public class knapsac_2 
{
    
    // Method to heapify the array
    private static void heapify(Item[] arr, int n, int i) 
    {
        int largest = i;
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
    }

  
    private static void heapSort(Item[] arr) 
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) 
        {
            Item temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the profit and weight of item no " + (i + 1) + ": ");
            double profit = scanner.nextDouble();
            double weight = scanner.nextDouble();
            items[i] = new Item(i + 1, profit, weight);
        }

        System.out.print("Enter the capacity of knapsack: ");
        double capacity = scanner.nextDouble();

        // Sort items based on profit/weight ratio
        heapSort(items);

        double totalProfit = 0.0;
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) 
        {
            if (capacity == 0) break;

            if (items[i].item_weight <= capacity) 
            {
                amounts[i] = 1;
                totalProfit += items[i].item_profit;
                capacity -= items[i].item_weight;
            } 
            else 
            {
                amounts[i] = capacity / items[i].item_weight;
                totalProfit += items[i].item_profit * amounts[i];
                capacity = 0;
            }
        }

        System.out.println("\nItem No\t\tProfit\t\tWeight\t\tAmount to be taken");
        for (int i = 0; i < n; i++) 
        {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n", items[i].item_id, items[i].item_profit, items[i].item_weight, amounts[i]);
        }
        
        System.out.printf("Maximum profit: %.2f\n", totalProfit);
    }
}

