/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

/**
 *
 * @author Tim
 */
public class quickSort {
    //zelf nagemaakt
    public int partition2(int[] arr, int low, int high){
        int pivot = arr[high];
        int lowest = (low - 1);
        
        for(int i = low; i < high; i++){
            if(arr[i] <= arr[high]){
                lowest++;
                
                int temp = arr[i];
                arr[i] = arr[lowest];
                arr[lowest] = arr[i];  
            }
        }
        
        int temp = arr[lowest + 1];
        arr[lowest + 1] = arr[high];
        arr[high] = temp;
        
        return lowest + 1;
    }
    
    public void sort2(int[] arr, int low, int high){
        if(low < high){
            int partitionIndex = partition2(arr, low, high);
            
            sort2(arr, low, partitionIndex - 1);
            sort2(arr, partitionIndex + 1, high);
        }
    }

    
    //origineel
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= arr[high])
            {
                i++;
 
                // swap arr[i] and arr[j] IF POSSIBLE
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int partitionIndex = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, partitionIndex-1);
            sort(arr, partitionIndex+1, high);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
 
        quickSort ob = new quickSort();
        ob.sort(arr, 0, n-1);
 
        System.out.println("sorted array");
        printArray(arr);
    }
}
