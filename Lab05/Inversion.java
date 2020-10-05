import java.util.*;

public class Inversion { 
  
    // Function to count the number of inversions 
    // during the merge process 
    private static int mergeAndCount(int[] arr, int l, int m, int r) { 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j])
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
        return swaps; 
    } 
  
    // Merge sort function 
    private static int mergeSort(int[] arr, int l, int r) {
        int count = 0; 
        if (l < r) { 
            int m = (l + r) / 2; 

            // Left subarray count 
            count += mergeSort(arr, l, m); 

            // Right subarray count 
            count += mergeSort(arr, m + 1, r); 

            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        } 
        return count; 
    } 
  
    // Driver code 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mergeSort(arr, 0, arr.length - 1)); 
    } 
} 