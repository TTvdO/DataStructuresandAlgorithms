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
public class binarySearch {

    public int binarySearch(int[] a, int low, int high, int value){
        if(low <= high){
            int mid = (low + high) / 2;
            
            if(a[mid] == value){
                return mid;
            }
            else if(value > a[mid]){
                return binarySearch(a, mid + 1, high, value);
            }
            else{
                return binarySearch(a, low, mid - 1, value);
            }
        }
        else{
            return -1;
        }
    }
}
