public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them
	class Node<M>{
		Node<M> next;
		M val;
		
		public Node(M val, Node<M> next) {
			this.val = val;
			this.next = next;
		}
	}

	
	Node<T> head;
	Node<T> tail;
	int size;
	
   public Queue()
   {
	   head = null;
	   tail = null; 
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   Node<T> newNode = new Node<T>(val, null);
	   if(isEmpty()) {
		   head = newNode;
		   tail = newNode;
	   }else {
		   tail.next = newNode;
		   tail = newNode;
	   }
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     * @throws QueueUnderFlowException 
     */
   public T pop() throws QueueUnderFlowException
   {   
	   if(isEmpty()) {
		   throw new QueueUnderFlowException();
	   }
	   T val = head.val;
	   head = head.next;
	   return val;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return head == null;
   }




}
