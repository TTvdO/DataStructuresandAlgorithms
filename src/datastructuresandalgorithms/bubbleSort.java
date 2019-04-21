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
public class bubbleSort {
    public int[] bubbleSort(int[] a){
        int temp = 0;
        
        for(int i = 0; i < a.length -1; i++){
            for(int j = 0; j < a.length - 1 - i; j++){
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        
        return a;
        
    }
}
