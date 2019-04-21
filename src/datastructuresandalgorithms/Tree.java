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
public class Tree {
    private Node root;
    
    class Node{
        Comparable data;
        Node left;
        Node right;
        
        public void addNode(Node newNode){
            int comp = newNode.data.compareTo(data);
            
            if(comp > 0){
                if(left == null){
                    left = newNode;
                }
                else{
                    left.addNode(newNode);
                }
            }
            else{
                if(right == null){
                    right = newNode;
                }
                else{
                    right.addNode(newNode);
                }
            }
        }
    }
    
    public Tree(Comparable rootData, Tree left, Tree right){
        root = new Node();
        root.data = rootData;
        root.left = left.root;
        root.right = right.root;
    }
    
    public void add(Comparable obj){
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if(root == null){
            root = newNode;
        }
        else{
            root.addNode(newNode);
        }
    }
    
    public boolean find(Comparable obj){
        Node current = root;
        
        while(current != null){
            int comp = obj.compareTo(current.data);
            
            if(comp == 0){
                return true;
            }
            else if(comp > 0){
                current = current.right;
            }
            else{
                current = current.left;
            }
        }
        return false;
    }
    
    public void remove(Comparable obj){
        Node toBeRemoved = root;
        Node parent = null;
        boolean found = false;
        
        while(!found && toBeRemoved != null){
            int comp = obj.compareTo(toBeRemoved.data);
            
            if(comp == 0){
                found = true;
            }
            else{
                parent = toBeRemoved;
                if(comp > 0){
                    toBeRemoved = toBeRemoved.right;
                }
                else{
                    toBeRemoved = toBeRemoved.left;
                }
            }
        }
        if(!found){
            return;
        }
        
        if(toBeRemoved.left == null || toBeRemoved.right == null){
            Node newChild;
            
            if(toBeRemoved.left == null){
                newChild = toBeRemoved.right;
            }
            else{
                newChild = toBeRemoved.left;
            }
            
            if(parent == null){
                root = newChild;
            }
            
            else if(parent.left == toBeRemoved){
                parent.left = newChild;
            }
            
            else{
                parent.right = newChild;
            }
            return;
        }
        
        
    }
    
}
