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
public class BinarySearchTree {
    private Node root;
    
    class Node{
        Comparable data;
        Node left;
        Node right;
        
        public void addNode(Node newNode){
            int comp = newNode.data.compareTo(data);
            
            if(comp < 0){
                if(left == null){
                    left = newNode;
                }
                else{
                    left.addNode(newNode);
                }
            }
            else if(comp > 0){
                if(right == null){
                    right = newNode;
                }
                else{
                    right.addNode(newNode);
                }
            }
        }
    }
    
    public BinarySearchTree(Comparable rootData, BinarySearchTree left, BinarySearchTree right){
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
    
    private static int height(BinarySearchTree.Node n){
        if(n == null){
            return 0;
        }
        else{
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }
    
    public boolean find(Comparable obj){
        BinarySearchTree.Node current = root;
        
        while(current != null){
            int comp = root.data.compareTo(obj);
            
            if(comp == 0){
                return true;
            }
            else if(comp > 0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return false;
    }
    
    public void remove(Comparable obj){
        Node toBeRemoved = root;
        Node parent = null;
        boolean found = false;
        
        while(!found && toBeRemoved != null){
            int d = obj.compareTo(toBeRemoved.data);
            if(d == 0){
                found = true;
            }
            else{
                parent = toBeRemoved;
                if(d > 0){
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
        
        Node smallestParent = toBeRemoved;
        Node smallest = toBeRemoved.right;
        
        while(smallest.left != null){
            smallestParent = smallest;
            smallest = smallest.left;
        }
        
        toBeRemoved.data = smallest.data;
        if(smallestParent == toBeRemoved){
            smallestParent.right = smallest.right;
        }
        else{
            smallestParent.left = smallest.right;
        }
        
        
    }
    
}
