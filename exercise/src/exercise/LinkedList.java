package exercise;

public class LinkedList {
	  private int data;
	  private LinkedList next;
		
	  public LinkedList(int data, LinkedList next) {
	  	this.data = data;
	    this.next = next;
	  }
	  
	  public int getData() {
	  	return data;
	  }
		
	  public void setData(int data) {
	  	this.data = data;
	  }

		public LinkedList getNext() {
	  	return next;
	  }
		
	  public void setNext(LinkedList next) {
	  	this.next = next;
	  }
	  
	  public String toString() {
	  	if (this.getNext() == null){
	  		return "" + this.getData();
	  	}
		String s = "" + this.getData() + this.getNext().toString();
	    return s;
	  }
	  
	  public boolean contains(int value) {
		    if (this.getData() == value){
		    	return true;
		    }
		    else{
		    	if (this.getNext() == null){
		      	return false;
		      }
		      return this.getNext().contains(value);
		      }
		  }
	  
	  public void removeNext() {
		  	// Before: 1 > 2 > 3
		    // After: 1 > 3
		  if(next != null){
		    next = next.getNext();
		  }
		    
		  }
	  
	  public LinkedList reverse() {
		  	LinkedList head = this;
		  	LinkedList branch = null;
		    LinkedList temp;
		    
		    while (head != null) {
		    	head = head.next;
		    	head.next = branch;//��תָ��
		    	branch = head;
		    	
		    }
		    return branch;
		  }
		    
	  public static void main(String[] args) {
	  	LinkedList h = new LinkedList(5, null);
	    LinkedList hh = new LinkedList(4, h);
	    LinkedList hhh = new LinkedList(3, hh);
	    LinkedList hhhh = new LinkedList(2, hhh);
	    LinkedList hhhhh = new LinkedList(1, hhhh);
	    
	    System.out.println(hhhhh.toString());
	    System.out.println(hhhhh.contains(1));
	    System.out.println(h.contains(1));
	    LinkedList a = hhhhh.reverse();
	    System.out.println(a.toString());

	    
	  }
}
	  