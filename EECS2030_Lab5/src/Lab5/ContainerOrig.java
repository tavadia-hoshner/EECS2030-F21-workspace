package Lab5;

public class ContainerOrig {
	// Do not change the value of the following constants.
	protected final int ORIGINAL_SIZE = 10; 
	protected Object[] list; // is a container that stores the element of MyList
	protected Object[] set; // is a container that stores the element of MySet
	protected int size; // this variable holds the actual number of elements that are stored in either of the containers (i.e. MyList or MySet).
	/**
	 * This method adds the <code> obj </code> to the end of the container.
	 * @param obj is the object that is added to the container.
	 */
	void add(Object obj) {
		System.out.println("The object was added to the contianer");
	}
	/**
	 * This method removes the <code> obj </code> from the container. 
	 * It shifts all the elements to make sure that removal of the element
	 * does not create a whole in the container.
	 * @param obj is the object that is removed from the container. 
	 * @return It returns the object that was removed.
	 */
	Object remove(Object obj) {
		System.out.println("The object was removed from the container.");
		return obj;
	}
	/**
	 * This method returns true if the container is empty.
	 * @return It returns true if the container is empty, otherwise false.
	 */
	boolean isEmpty() {
		// you may want to change this return value
		if(size==0)return true;
		else return false;
	}
	/**
	 * This method returns the number of elements stored in the container.
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// you may want to change this return value.
		return size;
	}
	

}

/**
 * 
 * This class simulates an ArrayList, where you can add unlimited number of 
 * elements to the list.
 *
 */
class MyList extends ContainerOrig{
	/**
	 * This is the default constructor that sets all the instance variables to their defualt value. 
	 */
	public MyList () {
		list= new Object[ORIGINAL_SIZE];
		size = 0; 
	}
	
	/**
	 * This method returns the element that is stored at index <code> index </code>.
	 * @param index is the<code> index </code> at which the element is accessed and returned. 
	 * @return it returns the element stored at the given <code> index </code>.
	 */
	public Object get(int index) {
		// insert your code here. You may want to change the return value. 
		return list[index]; 	
	}
	/**
	 * This method overrides the <code> add </code> method defined in class <code> container</code>. By
	 * adding the <code> obj </code> to the back of the <code> list </code> array. 
	 * The original size of the <code> array </code> is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this array. In case the array does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> list </code> array.     
	 */
	@Override
	void add(Object obj) {
		// insert your code here
		try {
		if(list[size]==null) {
			list[size]=obj;

			size++;
		}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			Object[] temp = new Object[size*2];
			temp[0]=list[0];
			for(int i=1;i<size;i++) 
					temp[i] = list[i];
			temp[size] = obj;	
			list = temp;
			size++;
		}
	}

	
	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> list </code>
	 * @pre <code> obj </code> exists in the <code>list</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		// insert your code here. You may want to change the return value.
		int index = -1;
		for(int i=0;i<size;i++) {
			if(obj==list[i] || obj.equals(list[i])) {
				index=i; 
				break;
			}
		}
		for(int i=index+1;i<size;i++) {
			Object temp = list[i];
			list[i]=list[i-1];
			list[i-1] = temp;
		}
		list[size-1]=null;
		size--;
		return list[index];
	}

	/**
	 * This method returns the elements of the MyList in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.	
		String temp = "[";
		for(int i=0;i<size;i++) {
			temp = temp + list[i]+" ";
		}
		if(size>0)
			temp = temp.substring(0, temp.length()-1);
		temp = temp+"]";
		return temp;
	}


}

class MySet extends ContainerOrig{
	public MySet() {
		set = new Object[ORIGINAL_SIZE];
		size = 0; 
	}
	
	/**
	 * This method overrrides the <code> add </code> method defined in class <code> container</code>. By
	 * adding the <code> obj </code> to the back of the <code> set </code> array. 
	 * The original size of the <code> set </code> is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this set. In case the set does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> set </code> array.      
	 */
	
	@Override
	void add(Object obj) {
		// insert your code here.
		boolean doesnotexist = true;
		for(int i=0;i<size;i++) {
			if(obj==set[i] || obj.equals(set[i])) {
				doesnotexist=false; 
			}
		}
		if(doesnotexist) {
			try {
				if(set[size]==null) {
					set[size]=obj;

					size++;
				}
				}
			catch (ArrayIndexOutOfBoundsException e) {
				Object[] temp = new Object[size*2];
				temp[0]=set[0];
				for(int i=1;i<size;i++) 
						temp[i] = set[i];
				temp[size] = obj;	
				set = temp;
				size++;
			}
		}
		
	}
	
	
	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> set </code>
	 * @pre <code> obj </code> exists in the <code>set</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		// insert your code here. You may want to change the return value.
		int index = -1;
		for(int i=0;i<size;i++) {
			if(obj==set[i] || obj.equals(set[i])) {
				index=i; 
				break;
			}
		}
		for(int i=index+1;i<size;i++) {
			Object temp = set[i];
			set[i]=set[i-1];
			set[i-1] = temp;
		}
		set[size-1]=null;
		size--;
		return set[index];
	}
	
	/**
	 * This method returns the elements of the MySet in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	
	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.		
		String temp = "[";
		for(int i=0;i<size;i++) {
			temp = temp + set[i]+" ";
		}
		if(size>0)
			temp = temp.substring(0, temp.length()-1);
		temp = temp+"]";
		return temp;
	}
	
}
