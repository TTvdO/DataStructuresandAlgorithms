/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public class DirectoryTree {
    private Node root;
    
    class Node{
        Object data;
        List<Node> children;
        
        public int size(){
            int sum = 0;
            
            for(Node child : children){
                sum = sum + child.size();
            }
            
            return sum;
        }
    }
    
    public DirectoryTree(Object rootData){
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }
    
    public void addSubtree(DirectoryTree subtree){
        root.children.add(subtree.root);
    }
    
    public int size(){
        return root.size();
    }
    
}
