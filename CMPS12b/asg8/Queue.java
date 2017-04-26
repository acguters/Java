//Queue.java
//Set of functions used in the creation of the Queue utilized in asg8
//Special Instructions: type "make test" to run test, to print out tree, however, type
// "java xref -d test.java" or whatever .txt file you are testing.
//type make clean to clean class files as well as executable

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

class Queue <Item> implements Iterable <Item> {

   private class Node {
      Item item;
      Node next;
   }
   private Node head = null;
   private Node tail = null;
   private Node current = head;
   		 
   	public boolean hasNext(){
   	   	 return current != null;
    }
//----------------------------------------------------------------------------------------
//Changed these functions

   public boolean isempty() {
      if (head == null){
      	return true;
      }					//checks to see if Queue is empty or if head/tail == 0
      else if (tail == null){
      return true; //if empty return true
      
      }
      else if (head!= null || tail!= null){ //if not empty
      	return false;	//if holds value return false
      }
    	else return false;	  //all else false
   }


   public void insert(Item newitem) {
      
       if (hasNext() == true){
      throw new RuntimeException();		//throws exception
      }
      
   		Node node = new Node();
    	node.item = newitem;
    	node.next = null;
      	
      	if (isempty()){ //if Queue is empty
       		head = node; //insert newNode
			tail = node;	
     	}
     	
     	else if (!isempty()){  //if Queue is not empty
      		tail.next = node; //add node at the end/tail
     	 	tail = node;
      }
   }
//----------------------------------------------------------------------------------------
   public Iterator <Item> iterator() {
      return new Itor ();
   }

   class Itor implements Iterator <Item> {
      Node current = head;
      public boolean hasNext() {
         return current != null;
      }
      public Item next() {
         if (! hasNext ()) throw new NoSuchElementException();
         Item result = current.item;
         current = current.next;
         return result;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

}
