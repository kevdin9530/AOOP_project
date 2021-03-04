package firstAssignment;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * A stack collection of messages.
 * @invariant theArrayM.size() >= 0
 */

public class MessageStack {
	
	 private  ArrayList<Message> theArrayM;
	 /**
		* Constructs an empty message Stack.
		* the maximum capacity of the stack
	 */

	 public  MessageStack() {
		 theArrayM = new ArrayList<Message>();
		 
	 }
	 
	 /**
		 * Get the total number of messages in the stack.
		 * 
		 * 
		 * @return the total number of messages in the stack
		 */
	 public int size(){
		 
		 return theArrayM.size();
	 }
	 
	 /**
		 * PushOneM a message into the stack.
		 * 
		 * @param val
		 *        the message to be appended
		 *        @postcondition size() > 0
		 */
	 public void pushOneM(Message val) {
	
		 theArrayM.add(val);
		assert size() > 0 : "Something went wrong";
	 }
	 
	 /**
		 * Remove top message.
		 * @return the message that has been removed from the top of the stack
		 * @precondition size() > 0
		 */
	 public  Message popOneM() {
		 
		 assert size() > 0 : "There is no message on the stack :( ";
		 Message a = theArrayM.get(theArrayM.size()-1);
		 theArrayM.remove(theArrayM.size()-1);
		 return a;
	 }
	 
	 /**
		 * Push a list into the stack.
		 * @param n, a
		 * number of messages that should be pushed into the stack
		 *  a is the list that we taking the messages from.
		 */ 
	 public void pushListMessage(int n, ArrayList<Message> a) {
		 for(int i =0; i<n;i++) {
			 pushOneM(a.get(i));
		 }
		 
	 }
	 
	 /**
		 * Popping n number of messages from the stack to a list.
		 * 
		 * @return messageList
		 * @param n
		 * number of messages that will be popped.
		 * 
		 * @precondition size() > n
		 */
	 public ArrayList<Message> popListMessage(int n){
		 
		assert size() > n : "Failed precondition size() > n :(";
			 
		 ArrayList<Message> messageList = new ArrayList<>();
		 
		 for(int i=0; i<n;i++) {
			 messageList.add(popOneM());
		 }
		 
		 return messageList;
	 }
	 public String toString() {
		 String a = "[";
		
		 for(int i = 0; i<theArrayM.size()-1; i++) {
			a +=   popOneM().getText()+ ",";
			 
		 }
		 a+="]";
		 return a;
	 }
	 
	
	public static void main(String[] args) {
		
		MessageStack a = new MessageStack();
		ArrayList<Message> listan = new ArrayList<>();
		Message hej = new Message("hej");
		Message hejda = new Message("hejda");

		a.pushOneM(hej);
		a.pushOneM(hejda);
		a.pushOneM(hejda);
//		a.pushOneM(hej);
		System.out.println("size test "+a.size());
		a.popOneM();
		
		System.out.println("size test after pop " + a.size());
		

		//ArrayList<Message> poppadLista = a.popListMessage(1);
	//	System.out.println(poppadLista.toString());
		System.out.println("----------------------");
		System.out.println("print with override toString method" + listan.toString());
		System.out.println(a.size());
		
//		for(int i = 0; i<topOfStack;i++)
//			System.out.println(theArray[]);
		
		
	}

}
