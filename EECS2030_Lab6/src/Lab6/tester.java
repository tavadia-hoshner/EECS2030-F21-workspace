package Lab6;

import java.util.List;

public class tester {
	public static void main(String[] args) {
		Container c = new Queue("in.txt");
		System.out.println(c.getSize());
		c.add("Object 1");
		c.add("Object 2");
		c.add("Object 3");
		c.remove();
		c.add("Object 4");
		c.add("Object 5");
		c.remove();
		c.add("Object 6");
		System.out.println(c.getSize());
		System.out.println("Queue Begins:");
		int x = c.getSize();
		for(int i=0;i<x;i++) {
			
			System.out.println(i+" "+c.remove());
		}
		
		
	}

}
