import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{
   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
      head = null;
      
   }


    //@Override
   public void push(T val) {
	    Node<T> newNode = new Node<>(val, null);
	    if(head == null) {
	    	head = newNode;
	    	return;
	    }
	    if (compare.compare(val, head.val) > 0) {
	        newNode.next = head;
	        head = newNode;
	        
	    } else {
	        Node<T> current = head;
	        while (current.next != null && compare.compare(val, current.next.val) < 0) {
	            current = current.next;
	        }
	        newNode.next = current.next;
	        current.next = newNode;
	    }
	}


}
