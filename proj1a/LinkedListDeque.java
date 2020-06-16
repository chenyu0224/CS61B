
public class LinkedListDeque<T> { 
	/**
     *  The first item (if it exists) in the deque is the sentinel.next
     */
	    private IntNode sentinel;
	    private int size;

	    private class IntNode {
	        public IntNode prev;
	        public T item;
	        public IntNode next;    
	        
	        public IntNode(IntNode p, T i, IntNode n) {
	        	prev = p;
	        	item = i;
	        	next = n;
	        }
	        
	        
	    }
	    
	    /**
	     * Create an empty deque
	     */
	    public LinkedListDeque() {
	    	size = 0;
	    	sentinel = new IntNode(null,null,null);
	    	//之前只写了二者相等！没有写等于sentinel！！！
	    	sentinel.next = sentinel.prev = sentinel;
	    	
	    }
	    
	    /**
	     * Add an item of type T to the front of the deque
	     */
	    public void addFirst(T item) {
	       sentinel.next = new IntNode(sentinel,item,sentinel.next);
	       sentinel.next.next.prev = sentinel.next;
	       size += 1;
	    }
	    
	    /**
	     * Add an item of type T to the back of the deque
	     */
	    public void addLast(T item) {
	    	sentinel.prev = new IntNode(sentinel.prev,item,sentinel);
	    	sentinel.prev.prev.next = sentinel.prev;
	    	size += 1;
	    	
	    }
	    
	    /**
	     * Return true if deque is empty, false otherwise
	     */
	    public boolean isEmpty() {
	    	return size == 0;
	    }
	    
	    /**
	     * Return the number of items in the deque
	     */
	    public int size() {
	    	return size;
	    }
	    
	    /**
	     * Print the items in the deque from first to last, separated by a space
	     * Once all the items have been printed, print out a new line
	     */
	    public void printDeque() {
	    	IntNode p = sentinel.next;
	    	//不可以while(p.next!=null)
	    	int k = size;
	    	while(k!=0) {
	    		System.out.print(p.item+" ");
	    		p = p.next;
	    		k -= 1;
	    	}
	    	System.out.println();
	    	
	    }
	    
	    /**
	     * Remove and return the item at the front of the deque
	     * If no such item exists, return null
	     */
	    public T removeFirst() {
	    	IntNode p = sentinel.next;
	        sentinel.next = sentinel.next.next;
	        sentinel.next.next.prev = sentinel;
	        p.next.prev = sentinel.next;
	        if(!isEmpty()) {
	    	size -= 1;
	        }
	    	return p.item;	
	    	
	    }
	    
	    /**
	     * Remove and return the item at the back of the deque
	     * If no such item exists, return null
	     */
	    public T removeLast() {
	    	IntNode p = sentinel.prev;
	    	p.prev.next = p.next;
	    	p.next.prev = p.prev;
//	    	sentinel.prev = sentinel.prev.prev;
//	    	sentinel.prev.prev.next = sentinel;
	    	if(!isEmpty()) {
		    	size -= 1;
		        }
	    	return p.item;	
	    
	    }
	    
	    /**
	     * Get the item at the given index, where 0 is the front,
	     * 1 is the next item, and so forth. If no such item exists,
	     * return null. Must not alter the deque
	     */
	    public T get(int index) {
	    	IntNode p = sentinel.next;
//	    	if(index > size-1) {
//	    		return null;
//	    		}
	    	while(index != 0) {
	    		p = p.next;
	    		index -= 1;
	    	}
	    	return p.item;	
	    	
	    }

	    
	    /**
	     * Same as get, but uses recursion
	     * First, need a private helper method
	     */
	    private T getRe(IntNode p ,int index) {
	    	 
	    	if(index == 0) {
	    		return p.item;
	    	}
	    	return getRe(p.next, index-1);
	    }
	    public T getRecursive(int index) {
	    	IntNode p = sentinel.next;
	    	return getRe(p,index);
	    }
	    
 
	  
	    public static void main(String[] args) {
			LinkedListDeque<Integer> l = new LinkedListDeque<>();
			l.addFirst(5);
			l.addLast(66);
			l.addLast(98);
			System.out.println(l.size);
			l.printDeque();
			System.out.println(l.get(1));
			System.out.println(l.getRecursive(2));
			l.removeLast();
			System.out.println(l.size);
			System.out.println(l.get(1));
			l.printDeque();
		
//			l.removeLast();
//			l.printDeque();
//			System.out.println(l.isEmpty());
			
		}
}
