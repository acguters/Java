// dllist.java
// Code for doubly-linked list of strings.

public class dllist {

public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

  private class node {
    String item;
    node prev;
    node next;
  }

   private node first = null; 
   private node current = null;
   private node last = null;
   private int currentPosition = 0;
   private int numNodes = -1;

  public void setPosition (position pos) {
    
    switch(pos){
      case FIRST:
        current = first; 
        currentPosition = 0;
        return;
      case PREVIOUS: 
        if(current == first){
          return;
        }else{
        current = current.prev; 
        currentPosition--;
        return;
        }
      case FOLLOWING:
        if(current == last){
          return;
        }else{
        current = current.next; 
        currentPosition++;
        return;
        }
      case LAST:     
        current = last;
        currentPosition = numNodes;
        return;
      default : throw new UnsupportedOperationException();
    }

  }

  public boolean isEmpty () {
    
    if(current == null){
      return true;
    }else return false;
  }

  public String getItem () {
    try{
      return current.item;
    } catch (NullPointerException e) {
      throw new java.util.NoSuchElementException();
    }
  }

  public int getPosition () {
    try{
    return currentPosition;
    } catch (NullPointerException e) {
    throw new java.util.NoSuchElementException();
    }
  }

  public void delete () {
    try{
      if (current == first){
        first = current.next;
        current = first;
        numNodes--;
      }else if(current == last){
        last = current.prev;
        current = last;
        numNodes--;
        currentPosition--;
      }else{
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current = current.next;
        numNodes--;
      }
    } catch (NullPointerException e) {
      throw new java.util.NoSuchElementException();
    }
  }

  public void insert (String item, position pos) {
    numNodes++;
    node temp = new node();
    
    if(isEmpty()){
      first = temp;
      last = temp;
      current = temp;
      temp.item = item;
    }else{

    switch(pos){
      case FIRST:    
        temp.item = item;
        temp.next = first;
        first = temp;
        first.next.prev = first;
        current = first;
        currentPosition = 0;
        return;
      case PREVIOUS:
        try{
          if(current == first){
            temp.item = item;
            temp.next = current;
            current.prev = temp;
            current = temp;
            first = temp;
          }else {
            temp.item = item;
            temp.next = current;
            temp.prev = current.prev;
            current.prev = temp;
            temp.prev.next = temp;
            current = temp;
          }
        return;
        } catch (NullPointerException e) {
          throw new IllegalArgumentException();
        }
      case FOLLOWING:
        try{
          if(current == last){
            temp.item = item;
            temp.prev = current;
            current.next = temp;
            
            current = temp;
            last= temp;
          }else{
            temp.item = item;
            temp.next = current.next;
            temp.prev = current;
            current.next = temp;
            temp.next.prev = temp;
            current = temp;
          }
          currentPosition++;
          return;
        } catch (NullPointerException e) {
          throw new IllegalArgumentException();
        }
      case LAST:    
        temp.item = item;
        temp.prev = last;
        last = temp;
        last.prev.next = last;
        current = last;
        currentPosition = numNodes;
        return;
        
      default : 
        throw new IllegalArgumentException();
    }
    
    }
  }
  
  public int getLastPos(){
    return numNodes;
  }

}

