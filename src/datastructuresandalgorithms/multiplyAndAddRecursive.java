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
public class multiplyAndAddRecursive {
    public static void main(String[] args){
        System.out.println("Multiply: " + multiply(5, 4));
        
        System.out.println("Add: " + add(3, 4));
    }
    
    public static int multiply(int a, int b){
        if(b > 1){
            a += multiply(a, b - 1);
        }
        return a;
    }
    
    //nice versie van optellen
    public static int add(int a, int b){
        if(b == 0){
            return a;
        }
        
        return add(a + 1, b - 1);
    }
    
    public static int addIterative(int a, int b){
        int sum = a;
        
        for(int i = 0; i < b; i++){
            sum++;
        }
        
        return sum;
    }
    
    
    //slechtere versie van optellen
    public static int add2(int a, int b){
        if(b == 0){
            return a;
        }
        
        int result = add2(a, b - 1) + 1;
        
        return result;
    }
}
