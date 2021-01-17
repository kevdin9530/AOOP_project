package firstPart;

/**
 * A first-in, first-out bounded collection of messages.
 */
public class MessageQueue {
	/**
	 * Constructs an empty message queue.
	 * 
	 * @param capacity
	 *            the maximum capacity of the queue
	 * @precondition capacity > 0
	 */
	public MessageQueue(int capacity) {
		if(capacity <= 0)
			 throw new RuntimeException("Your queue most have atleast one spot :(");
		elements = new Message[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}

	/**
	 * Remove message at head.
	 * 
	 * @return the message that has been removed from the queue
	 * @precondition size() > 0
	 */
	public Message remove() {
		if(count <=0)
			 throw new RuntimeException("There is no elements to remove :(");

		Message r = elements[head];
		elements[head] = null;
		head = (head + 1) % elements.length;
		count--;
		return r;
	}
	public void doubleQueue() {
		Message [] newArray;
		
		newArray =  new Message[elements.length * 2 ];
		if(head ==0){
			tail = elements.length;
			for(int i = 0; i<elements.length; i++) {
				newArray [i] = elements[i];
			}
        }
		else {
			for(int i = 0; i <=tail; i++ ) {
				newArray[i] = elements[i];
			}
			for(int i = head+elements.length; i < newArray.length;i++) {
				newArray[i] = elements[i-elements.length];
			}
			head = head+elements.length;	
		}
		
        elements = newArray;        

	}

	/**
	 * Append a message at tail.
	 * 
	 * @param aMessage
	 *            the message to be appended
	 * @precondition !isFull();
	 */
	public void add(Message aMessage) {
		if(isFull()) 
			doubleQueue();
		elements[tail] = aMessage;
		tail = (tail + 1) % elements.length;
		count++;
	}

	/**
	 * Get the total number of messages in the queue.
	 * 
	 * @return the total number of messages in the queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Checks whether this queue is full
	 * 
	 * @return true if the queue is full
	 */
	public boolean isFull() {
		return count == elements.length;
	}

	/**
	 * Get message at head.
	 * 
	 * @return the message that is at the head of the queue
	 * @precondition size() > 0
	 */
	public Message peek() {
		
		if(size() <= 0)
			throw new RuntimeException("Your queue is empty :(");
		
			
		return elements[head];
	}
	
	public void printQueue() {
		if(head == 0) {
			for(int i = 0; i < count; i++) {
				System.out.println(elements[i].getText());
			}
		}
		else {
			for(int i = head; i < elements.length; i++) {
				System.out.println(elements[i].getText());

			}
			for(int i = 0; i < tail;i++)
				System.out.println(elements[i].getText());
		}
			
	}
	public static void main(String[] args) {
		
		MessageQueue a = new MessageQueue(2);
		Message q = new Message("q");
		Message e = new Message("e");
		Message r = new Message("r");
		Message t = new Message("t");
		Message y = new Message("y");
		Message u = new Message("u");

		a.add(q);
		a.add(e);
		a.add(t);
		a.remove();
		System.out.println("---------------------------");
		a.add(r);
		a.remove();
		a.remove();
		a.remove();
		a.remove();
		a.printQueue();

	}

	private  Message[] elements;
	private  int head;
	private  int tail;
	private int count;
}
