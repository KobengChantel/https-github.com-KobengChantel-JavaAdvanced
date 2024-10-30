package DummiesBook.Book5.chapter3_Recursion;
//A Sorting Program



// A Sorting Program using QuickSort
public class QuickSortApp {

    public static void main(String[] args) {
        // Define the length of the array
        int LEN = 100;
        // Create an array to hold unsorted random integers
        int[] unsorted = new int[LEN];

        // Fill the array with random integers from 1 to 100
        for (int i = 0; i < LEN; i++) {
            unsorted[i] = (int)(Math.random() * 100) + 1;
        }

        // Print the unsorted array
        System.out.println("Unsorted array:");
        printArray(unsorted);

        // Sort the array and return the sorted version
        int[] sorted = sort(unsorted);

        // Print the sorted array
        System.out.println("\n\nSorted array:");
        printArray(sorted);
    }

    // Helper method to print the contents of the array
    private static void printArray(int[] array) {
        System.out.println();
        // Loop through the array and print each element
        for (int i = 0; i < array.length; i++) {
            // Format the output for readability
            if (array[i] < 10)
                System.out.print(" ");
            System.out.print(array[i] + " ");
            // Print a newline after every 20 elements for better visibility
            if ((i + 1) % 20 == 0)
                System.out.println();
        }
    }

    // Array to be sorted (shared across methods)
    private static int[] a;

    // Method to sort the array using QuickSort
    public static int[] sort(int[] array) {
        // Assign the array to the class-level variable
        a = array;
        // Call the recursive sort method
        sort(0, a.length - 1);
        // Return the sorted array
        return a;
    }

    // Recursive QuickSort method
    public static void sort(int low, int high) {
        // Base case: If the low index is greater than or equal to the high index, return
        if (low >= high)
            return;

        // Partition the array and get the pivot index
        int p = partition(low, high);

        // Recursively sort the left part of the array
        sort(low, p);
        // Recursively sort the right part of the array
        sort(p + 1, high);
    }

    // Method to partition the array around a pivot
    public static int partition(int low, int high) {
        // Choose the pivot (first element of the current segment)
        int pivot = a[low];
        int i = low - 1; // Index of the smaller element
        int j = high + 1; // Index of the larger element

        // Loop to rearrange the elements based on the pivot
        while (i < j) {
            // Increment i until an element greater than or equal to pivot is found
            do {
                i++;
            } while (i <= high && a[i] < pivot);

            // Decrement j until an element less than or equal to pivot is found
            do {
                j--;
            } while (j >= low && a[j] > pivot);

            // If indices have not crossed, swap the elements
            if (i < j)
                swap(i, j);
        }
        // Return the partition index
        return j;
    }

    // Method to swap two elements in the array
    public static void swap(int i, int j) {
        int temp = a[i]; // Store the value at index i
        a[i] = a[j];     // Assign the value at index j to index i
        a[j] = temp;     // Assign the stored value to index j
    }
}
