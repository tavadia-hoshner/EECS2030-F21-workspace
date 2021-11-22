package Lab6;

import java.util.*;
import java.io.*;
/**
 * This class is a container that holds an unlimited number of 
 * String objects. It is able to remove objects and add objects.
 */

public class Container {
	// No instance variable should be defined for this class. 


	/**
	 * Reads the given file and add it into a list. 
	 * Each element of the list contains one line of the file. 
	 * @param fileName is the name of the file that is read in this method. 
	 */

	public static final List<String> readFile(String fileName) {
		// add your code here. You may change the return value.
		try {
			Scanner sc = new Scanner(new File(fileName));
			List<String> temp = new ArrayList<String>();
	        while (sc.hasNextLine()) {
	            temp.add(sc.nextLine());
	        }
	        sc.close();
	        return temp;
		}
		catch (FileNotFoundException e) {
			return null;
		}
		
		
	}
		
	/**
	 * This method adds the <code> obj </code> to the container.
	 * @param obj is the object that is added to the container.
	 */
	
	void add(Object object) {
		// insert your code here
	}

	/**
	 * This method removes the object from the container
	 * @return returns the removed object.
	 */
	Object remove() {
		// insert your code here. You may want to change the return value. 
		return null;
	}

	/**
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// insert your code here. You may need to change the return value. 
		return 0;
	}

}

/**
 * 
 * This class simulates a Queue, which is a data structure that insert and remove data 
 * by FIFO (first-in, first-out) rule
 *
 */
class Queue extends Container{
	ArrayList<String> queue; 
	
	/**
	 * This is the constructor that initializes the <code> queue </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Queue"
	 * @param fileName is the name of the file that is read.  
	 */
	public Queue(String fileName) {
		// insert your code here
		queue = (ArrayList<String>) Container.readFile(fileName);
		for(int i=0;i<queue.size();i++) {
			String s = queue.get(i);
			if(s.contains("Stack")) {
				queue.remove(i);
				i-=1;
			}
			else if(s.contains("Queue")) {
				queue.remove(i);
				queue.add(i,s.substring(5).trim());
			}
		}
	}
	
	/**
	 * This method adds the object into the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 * @param obj is the object that is added to the queue. 
	 */
	@Override
	public void add(Object obj) {
		// insert your code here
		queue.add((String) obj);
	}
	/**
	 * This method removes an object from the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 */
	@Override
	public Object remove() {
		// insert your code here. You may want to change the return value. 
		Object x = queue.get(0);
		if(x!=null)
			queue.remove(x);
		return x;
	}
	/**
	 * @return returns the object which is in front of the queue.
	 */
	public Object top() {
		// insert your code here. You may want to change the return value. 
		Object x = null;
		if(getSize()>0)
			x=queue.get(getSize()-1);
		return x;
	}
	
	/**
	 * Returns the number of items in the queue.
	 */
	@Override 
	public int getSize(){
		// insert your code here. You may want to change the return value. 
		return queue.size();
	}
}

/**
 * 
 * This class simulates a Stack, which is a data structure that insert and remove data 
 * by FILO (first-in, last-out) rule
 *
 */
class Stack extends Container{
	ArrayList<String> stack; 
	
	/**
	 * This is the constructor that initializes the <code> stack </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Stack"
	 * @param fileName is the name of the file that is read.  
	 */
	public Stack(String fileName) {
		// insert your code here.
		stack = (ArrayList<String>) Container.readFile(fileName);
		for(int i=0;i<stack.size();i++) {
			String s = stack.get(i);
			if(s.contains("Queue")) {
				stack.remove(i);
				i-=1;
			}
			else if(s.contains("Stack")) {
				stack.remove(i);
				stack.add(i,s.substring(5).trim());
			}
		}
	}
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public void add(Object obj) {
		// insert your code here.
		stack.add((String) obj);
	}
	
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public Object remove() {
		// insert your code here. You may want to change the return value. 
		if(stack.size()>0)
			return stack.remove(getSize()-1);
		return null; 	
	}
	/**
	 * @return returns the object which is on top of the stack.
	 */
	
	public Object top() {
		// insert your code here. You may want to change the return value. 
		Object x = null;
		if(getSize()>0)
			x=stack.get(getSize()-1);
		return x;
		
	}
	/**
	 * Returns the number of items in the stack.
	 */
	@Override 
	public int getSize() {
		// insert your code here. You may want to change the return value. 
	      return stack.size();	}
}