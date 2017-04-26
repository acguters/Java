//Tree.java
//Set of functions used in the creation of the binary tree in asg8, i.e. read file/insert
//Special Instructions: type "make test" to run test. To print out tree, however, type
// "java xref -d test.java" or whatever .txt file you are testing
//type make clean to clean class files as well as executable

import static java.lang.System.*;

class Tree {

    private class Node {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;
    private Node current = root; //for throwing exceptions
    
    public boolean hasNext(){
   	   	 return current != null;  //Used for exceptions being thrown
    }
//----------------------------------------------------------------------------------------   		 
   	//Edited/completed Functions 
   	   	
   	    private void debugHelper(Node tree, int depth) {
        // Your code here might be recursive
        int i = 0;
        String tmp = null;
        
        if (tree == null && depth == 0) {
            return;
        }
        else if (tree != null){
        	tmp = " ";     //sets value in binary tree for printing
          
          while (depth != 0 && i < depth){
            tmp = tmp+"  ";  //steps through tree to print
            i++;	
		  }  
		  
		//recursively steps through tree to print
        debugHelper(tree.left, depth+1); //recursively steps through tree to print
										//left to right in lexicographic order
        
        System.out.println(tmp+depth+" "+tree.key); //prints out tree

        debugHelper(tree.right, depth+1);
       
		   
     	}
    }
    

    private void outputHelper(Node tree) {
        //Your code here might be recursive

      
        if(tree == null){ //if empty return
        	return;
        }
        
 		 if(tree != null) {				//else print out tree in order
            outputHelper(tree.left);
            out.printf("%s :%s", tree.key, " "); //formatting
            
            for(Integer i: tree.value){
                System.out.print(""+i+" "); 		//prints out line value
            }
            System.out.println();
            outputHelper(tree.right);
        }
    }

    

    public void insert(String key, Integer linenum) {
        // Insert a word into the tree
        
        Node temp = new Node();  
        temp.key = key;
        temp.value = new Queue<Integer>();
        
       if (hasNext()){			//throws exception
      	throw new RuntimeException();
    
      }
      
        if(root == null){  //if no root
        	root = new Node();
        	root.key = key;
            temp.value.insert(linenum);
            root = temp;
            return;
        }
        
        	Node curr = null;	//sets curr pos to root node
            curr = root;
            
            while(curr != null){
           	 	Node parent = null;
                parent = curr;
                if(temp.key.compareTo(curr.key) < 0){
                    curr = curr.left;
                    if(curr == null){
                        temp.value.insert(linenum);
                        parent.left = temp;
                        return;
                    }
                }
                else if (temp.key.compareTo(curr.key) != 0){
                    curr = curr.right;
                    
                    }
                    
                else if(temp.key.compareTo(curr.key) == 0){
                    curr.value.insert(linenum);
                    return;
                }
                
                     if(curr == null){
                        temp.value.insert(linenum);
                        parent.right = temp;
                        return;
                    }
                       
                }
            
        
    }
//----------------------------------------------------------------------------------------
    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }

}
