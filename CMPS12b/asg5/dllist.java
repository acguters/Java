//filename: dllist.java
//description: a class that constructs a 
//doubly linked list for the text editor 
//to implement.

class dllist {

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

	   public void setPosition (position pos) {
		
	       switch (pos){

	       case FIRST:
	    	   currentPosition =0;
	    	   current=first;
	    	   break;

	       case LAST:
	    	   current =first;
	    	   currentPosition=0;
	    	   while(current.next != null){
	    		   current=current.next;
	    		   currentPosition++;
	    	   }
	    	   break;

	       case PREVIOUS:
	    	   if (current.prev ==null)
	    		   break;
	    	   current=current.prev;
	    	   currentPosition--;
	    	   break;

	       case FOLLOWING:
	    	   if (current.next == null)
	    		  break; 
	    	   current=current.next;
	    	   currentPosition++;
	    	   break;
	       }
	 
	   }

	   public boolean isEmpty () {
	        return first ==null;
	   //  throw new UnsupportedOperationException();
	   }

	   public String getItem () {
		return current.item;
	      //throw new UnsupportedOperationException();
	   }

	   public int getPosition () {
		return currentPosition;
	      //throw new UnsupportedOperationException();
	   }

	   public void delete () {
		   if (current.next==null){	   
			   if(first.next==null)
				   first=null;
			   else
			 	   last.prev.next=null;
			   last=last.prev;
			   current=last;
		   }
		   else if(current.prev==null){
			   if(first.next==null)
				   last =null;
			   else
			   	   first.next.prev=null;
			   first=first.next;
			   current=first;
		   }
		   else{
	    		  current.prev.next=current.next;
	    		  current.next.prev=current.prev;
	    		  current=current.next;
		   }
		   //throw new UnsupportedOperationException();
	   }
	   public void insertFirst (String item) {
		   node newnode = new node();
		   newnode.item=item;
		   if (isEmpty())
			   last=newnode;
		   else{
			   first.prev=newnode;
			   newnode.next=first;
		   }
		   first = newnode;
		   current=newnode;
		   //   throw new UnsupportedOperationException();
	   }
	   public void insertLast (String item) {
		   node newnode = new node();
		   newnode.item=item;
		   if (isEmpty())
			   first=newnode;
		   else{
			   last.next=newnode;
			   newnode.prev=last;
			   currentPosition++;
		   }
		   last = newnode;
		   current=newnode;
		   //   throw new UnsupportedOperationException();
	   }
	   public void insert (String item, position pos) {
		   node newnode = new node();
		   switch(pos){
		   case FIRST:
			   insertFirst(item);
			   currentPosition=0;
			   break;
		   case LAST:
			   insertLast(item);
			   current =first;
	    	   	   currentPosition=0;
	    	   	while(current.next != null){
	    		   current=current.next;
	    		   currentPosition++;
	    	   	}
	    	   	break;
		   case PREVIOUS:
			   if (current.prev==null){
				   insertFirst(item);
			   }else{
			   newnode.item=item;
			   newnode.prev=current.prev;
			   current.prev.next=newnode;
			   newnode.next=current;
			   current.prev=newnode;
			   current=newnode;
			   }
			   break;
		   case FOLLOWING:
			   if (current.next==null){
				   insertLast(item);
			   }else{
			   newnode.item=item;
			   newnode.next=current.next;
			   current.next.prev=newnode;
			   newnode.prev=current;
			   current.next=newnode;
			   current=newnode;
			   currentPosition++;
			   }
			   break;   
		   }
		    //  throw new UnsupportedOperationException();
	   }

}

