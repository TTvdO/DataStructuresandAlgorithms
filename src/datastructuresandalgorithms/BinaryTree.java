/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Tim
 */
public class BinaryTree {
    private Node root;
    
    class Node{
        Object data;
        Node left;
        Node right;
    }
    
    public BinaryTree(){
        root = null;
    }
    
    public BinaryTree(Object rootData, BinaryTree left, BinaryTree right){
        root = new Node();
        root.data = rootData;
        root.left = left.root;
        root.right = right.root;
    }
    
    public int height(){
        return height(root);
    }
    
    private static int height(Node n){
        if(n == null){
            return 0;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }
    
    public int getLeafCount(){
        return getLeafCount(root);
    }
    
    private int getLeafCount(BinaryTree.Node n){
        if(n == null){
            return 0;
        }
        else if(n.left == null && n.right == null){
            return 1;
        }
        else{
            return getLeafCount(n.left) + getLeafCount(n.right);
        }
    }
    
    private int leafCounter(BinaryTree.Node n){
        if(n == null){
            return 0;
        }
        else if(n.left == null && n.right == null){
            return 1;
        }
        else{
            return leafCounter(n.left) + leafCounter(n.right);
        }
    }
    
    private int countNodesWithOneChild(BinaryTree.Node n){
        if(n == null){
            return 0;
        }
        else if(n.left == null && n.right != null || n.left != null && n.right == null){
            return 1;
        }
        else{
            return countNodesWithOneChild(n.left) + countNodesWithOneChild(n.right);
        }
    }
    
    private void inorderTraversal(BinaryTree.Node n){
        if(n == null){
            return;
        }
        inorderTraversal(n.left);
        System.out.println(n);
        inorderTraversal(n.right);
    }
    
    private void preOrder(BinaryTree.Node n){
        if(n == null){
            return;
        }
        System.out.println(n);
        preOrder(n.left);
        preOrder(n.right);
    }
    
    private void postOrder(BinaryTree.Node n){
        if(n == null){
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n);
    }
    
    private void breadthFirst(BinaryTree.Node n){
        BinaryTree.Node traverse;
        
        if(n == null){
            return;
        }
        
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        
        queue.add(n);
        
        while(!queue.isEmpty()){
            traverse = queue.remove();
            
            System.out.println(traverse);
            
            if(traverse.left != null){
                queue.add(traverse.left);
            }
            
            if(traverse.right != null){
                queue.add(traverse.right);
            }
        }
    }
    
    
    public boolean isTreeBalanced(BinaryTree.Node n){
        if(n == null){
            return true;
        }
        
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        
        if(Math.abs(leftHeight - rightHeight) <= 1 && isTreeBalanced(n.left) && isTreeBalanced(n.right)){
            return true;
        }
        
        
        return false;
    }
    
}
