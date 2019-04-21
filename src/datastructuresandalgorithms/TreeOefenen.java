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
public class TreeOefenen {
    class Node{
        Object data;
        public List<Node> children;
        
            public int size(){
            int sum = 0;
            for(Node node : children){
                sum += node.size();
            }
            return 1 + sum;
        }
    }
    
    private Node root;
    
    public TreeOefenen(Object rootData){
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }
    
    public void addSubtree(TreeOefenen subtree){
        this.root.children.add(subtree.root);
    }
    
    
    
}
