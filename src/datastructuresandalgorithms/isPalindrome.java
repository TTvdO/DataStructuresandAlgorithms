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
public class isPalindrome {
    public static boolean isPalindrome(String text){
        if(text.length() <= 1){
            return true;
        }
        char first = text.toLowerCase().charAt(0);
        char last = text.toLowerCase().charAt(text.length() - 1);
        
        if(Character.isLetter(first) && Character.isLetter(last)){
            if(first == last){
                return isPalindrome(text.substring(1, text.length() - 1));
            }
            else{
                return false;
            }
        }
        else if(!Character.isLetter(last)){
            return isPalindrome(text.substring(0, text.length() - 1));
        }
        else{
            return isPalindrome(text.substring(1));
        }
    }
}
