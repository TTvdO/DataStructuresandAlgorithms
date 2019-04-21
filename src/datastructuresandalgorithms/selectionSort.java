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
public class selectionSort {
    
    public void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //swapt arr[i] met arr[j] als de waarde van arr[j] kleiner is. als de waarde van arr[j] niet kleiner is dan swapt hij met zichzelf, wat dus niets veranderd.
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            
        }
        
    }
    
    public void selectionSorter(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = arr[minIndex];
            
        }
    }
}
