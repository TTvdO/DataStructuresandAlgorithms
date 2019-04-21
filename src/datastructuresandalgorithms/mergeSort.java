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
public class mergeSort {
    public void mergeSort(int[] arr){
        if(arr.length <= 1){
            return;
        }
        
        int[] first = new int[arr.length / 2];
        int[] second = new int[arr.length - first.length];
        
        for(int i = 0; i < first.length; i++){
            first[i] = arr[i];
        }
        
        for(int j = 0; j < second.length; j++){
            second[j] = arr[j + first.length];
        }
        
        mergeSort(first);
        mergeSort(second);
        merge(first, second, arr);
        
    }
    
    
    public void merge(int[] first, int[] second, int[] arr){
        int iFirst = 0;
        int iSecond = 0;
        int k = 0;
        
        while(iFirst < first.length && iSecond < second.length){
            if(first[iFirst] < second[iSecond]){
                arr[k] = first[iFirst];
                iFirst++;
            }
            else{
                arr[k] = second[iSecond];
                iSecond++;
            }
            k++;
        }
        
        while(iFirst < first.length){
            arr[k] = first[iFirst];
            iFirst++;
            k++;
        }
        
        while(iSecond < second.length){
            arr[k] = second[iSecond];
            iSecond++;
            k++;
        }
    }
    
}
