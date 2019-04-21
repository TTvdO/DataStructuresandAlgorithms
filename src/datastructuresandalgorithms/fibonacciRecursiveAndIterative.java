/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class fibonacciRecursiveAndIterative {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        
        for(int i = 1; i <= n; i++){
            long f = fibIterative(i);
            System.out.println("fib(" + i + ") = " + f);
        }
    }
    
     public static long fibRecursive(int n){
        if(n <= 2){
            return 1;
        }
        else{
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
    }
     
    public static long fibIterative(int n){
        if(n <= 2){
            return 1;
        }
        
        int newValue = 1;
        int oldValue = 1;
        int olderValue = 1;
        
        for(int i = 3; i <= n; i++){
            newValue = oldValue + olderValue;
            olderValue = oldValue;
            oldValue = newValue;
        }
        
        return newValue;
    }
}
