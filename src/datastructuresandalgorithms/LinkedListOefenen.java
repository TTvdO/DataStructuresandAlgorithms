/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;


import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Tim
 */
public class LinkedListOefenen {
    
    public class Node{
        Object data;
        Node next;
    }
    
    private Node first;
    
    public LinkedListOefenen(){
        first = null;
    }
    
    public Object getFirst(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }
    
    public void addFirst(Object data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }
    
    public ListIterator listIterator(){
        return new LinkedListIterator();
    }
    
    class LinkedListIterator implements ListIterator{
        private Node position;
        private Node previous;
        private boolean isAfterNext;
        
        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
        }
        
        public Object removeFirst(){
            if(first == null){
                throw new NoSuchElementException();
            }
            Object element = first.data;
            first = first.next;
            return element;
        }
        
        public Object next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            previous = position;
            isAfterNext = true;
            
            if(position == null){
                position = first;
            }
            else{
                position = position.next;
            }
            return position.data;
        }
        
        public boolean hasNext(){
            if(position == null){
                return first != null;
            }
            else{
                return position.next != null;
            }
        }
        
        public void add(Object element){
            if(position == null){
                addFirst(element);
                position = first;
            }
            else{
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            isAfterNext = false;
        }
        
        public void remove(){
            if(!isAfterNext){
                throw new IllegalStateException();
            }
            
            if(position == first){
                removeFirst();
            }
            
            else{
                previous.next = position.next;
            }
            
            position = previous;
            isAfterNext = false;
            
        }
        
        
        public void set(Object element){
            if(!isAfterNext){
                throw new IllegalStateException();
            }
            
            position.data = element;
        }
    }
    
    public interface ListIterator{
        
    }
    
}
