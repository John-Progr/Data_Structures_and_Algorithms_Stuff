import java.util.NoSuchElementException; 
import java.io.PrintStream;

public class IntQueueImpl<T> implements IntQueue<T>{
    private ListNode<T> head;
	private ListNode<T> tail;
	private int size;
	
	
	
	
	
	public boolean isEmpty(){
	   return head==null;
	    }
		
		public void put(T data){
		  
		  if(isEmpty()){
		     head=tail=new ListNode<T>(data,null);
			
		  
		    
			
		  }else{
		  tail.setNext(new ListNode<T>(data,null));
          tail = tail.getNext(); 
		  }
		  
		  size++;
		 }
		  public T get() throws NoSuchElementException{
		       if(isEmpty()){
			      throw  new NoSuchElementException();
				}
				T v=head.getData();
				ListNode<T> t=head.getNext();
				head=t;
				size--;
				return v;
		  
		  
		  
		  }
		  
		  
		  public T peek() throws NoSuchElementException{
		      if(isEmpty()){
			      throw  new NoSuchElementException();
				  }else{
				  
				  return head.getData();
				  }
				  
			  
		  
		  
		  
		  
		  
		  }
		  
		  
		  
		  public void printQueue(PrintStream stream){
		     ListNode cur = this.head;
		     while (cur != null) {
			    stream.println(cur.getData());
			    cur = cur.getNext();
			}
		     
		  
				
				
		  
		  
		  }
		  
		  public int size(){
		      
			  return size;
		  
		  
		  
		  
		  }
		  
}