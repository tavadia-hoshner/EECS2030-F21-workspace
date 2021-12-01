package Lab8;
import java.util.List;
import java.util.ArrayList;

/**
 * This class contains a number of methods that 
 * works on a wide range of data types. 
 */

/* This is a parameterized class. You should decide 
* what the parameter should look like in order to 
* pass all the test cases. 
*/
public class Utility<T>  {  //Change this line to create a parameterized class
	ArrayList list;
	// Insert your code here
	public Utility() {		
		list = new ArrayList<T>();
	}
	
	public Utility(List<T> copy) {		
		list = new ArrayList<T>();
		for(int i=0;i<copy.size();i++) {
			list.add(copy.get(i));
		}
		
	}
	
	public int linearSearch(T keyword){
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(keyword)) return i;
		}
		return -1;
	}
	
	public void mergeList(List copy) {
		copy = (List<T>) copy;
		int len = list.size();
		for(int i=0;i<len;i++) {
			copy.add(list.get(i));
		}
	}
	
	public boolean containList(List list){
		list = (ArrayList<T>) list;
		if (this.list.containsAll(list)) { 
			this.list = new ArrayList<T>();  
			for (int i=0;i<list.size();i++)  
				this.list.add(i); 
			return true; 
		} 
		else 
			return false;
	}
	
	public void removeZero(List myList) {
		list = (ArrayList<Integer>) list;
		  for (int i = 0; i < myList.size(); i++) { 
			  MyInteger x =(MyInteger) myList.get(i);
			   if(MyInteger.isZero(x)) { 
			    myList.remove(i); 
			    i--; 
			   } 
		  }
	}
}
/**
 * This class implements a 2D points. 
 */
class Point implements Comparable<Point>{
	double x; 
	double y; 
	public Point(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	@Override 
	public int compareTo(Point p) {
		if (this.x == p.x && this.y == p.y) return 0;
		else if (this.x == p.x) return 1;
		else return -1;	
	}
}

/**
 * This class represents an Integer number. 
 */
class MyInteger implements Comparable<MyInteger>{
	int x; 
	public MyInteger() {
		this.x = 0; 
	}
	public MyInteger(int x) {
		this.x = x; 
	}
	public static boolean isZero(MyInteger input) {
		return input.x == 0; 
	}
	@Override
	public int compareTo(MyInteger input) {
		if (this.x == input.x ) return 0;
		else if (this.x < input.x) return -1;
		else return 1;	
	}
}
/**
 * This class represents a subset of integer numbers that are natural numbers. 
 */
class NaturalNumber extends MyInteger{
	public NaturalNumber(int x) {
		super(x);
	}
}
/**
 * This class represents the odd natural numbers. 
 */

class OddNumber extends NaturalNumber{
	public OddNumber(int x) {
		super(x);
	}
	
}
/**
 * This class represents the even natural numbers. 
 */
class EvenNumber extends NaturalNumber{
	public EvenNumber(int x) {
		super(x);
	}
}