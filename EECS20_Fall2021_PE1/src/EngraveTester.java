

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * A set of JUnit test cases to test engrave.java
 * 
 * @author Marzieh Ahmadzadeh
 *
 */
class EngraveTester {
	@Test
	void drawLineTest1() {
		Engrave e = new Engrave();
		e.drawLine (6, '4');
		boolean equal = e.charPrintCount == 8; 
		assertEquals(true, equal, "drawLine (6, '4'); is not correct");
	}
	
	@Test
	void drawLineTest2() {
		Engrave e = new Engrave();
		System.out.println();
		e.drawLine (1, ' ');
		e.drawLine (2, ' ');
		e.drawLine (1, ' ');
		e.drawLine (3, ' ');
		e.drawLine (1, ' ');
		e.drawLine (2, ' ');
		e.drawLine (1, ' ');
		System.out.println();
		boolean equal = e.charPrintCount == 25; 
		assertEquals(true, equal, "drawLine (6, '4'); is not correct");
	}

	@Test
	void drawLineTest4() {
		Engrave e = new Engrave();
		e.drawLine (0, 'A');
		boolean equal = e.charPrintCount == 2; 
		assertEquals(true, equal, "drawLine (0, 'A'); is not correct");
	}

	@Test
	void CupSelectiontest1() {
			int value[] = new int[] {60, 50, 20};
			int weight[] = new int[]  {30,  30 , 10};
			int result = Engrave.cupSelection(weight, value,50,  3);
			assertEquals(80, result, "80 expected but "+ result+ "is given");
	}
	
	@Test
	void CupSelectiontest2() {
			int value[] = new int[] {5,12,8,1,10};
			int weight[] = new int[]  {100,200,300,400,500};
			int result = Engrave.cupSelection(weight, value,600,  5);
			assertEquals(25, result, "25 expected but "+ result+ "is given");
	}
	
	@Test
	void CupSelectiontest3() {
			int value[] = new int[] {60,120,100,100,30,20};
			int weight[] = new int[]  {10,30,20,20,30,10,};
			int result = Engrave.cupSelection(weight, value,50,  6);
			assertEquals(260, result, "260 expected but "+ result+ "is given");
	}
	
	@Test
	void CupSelectiontest4() {
			int value[] = new int[] {100,120,180,150,200};
			int weight[] = new int[]  {50,70,85,130,160};
			int result = Engrave.cupSelection(weight, value,170,  5);
			assertEquals(280, result, "280 expected but "+ result+ "is given");
	}
	
	@Test
	void CupSelectiontest5() {
			int value[] = new int[] {60,130,70,80,110,40};
			int weight[] = new int[]  {20,40,30,30,50,20};
			int result = Engrave.cupSelection(weight, value,140,  6);
			assertEquals(380, result, "380 expected but "+ result+ "is given");
	}
	
	@Test
	void CupSelectiontest6() {
			int value[] = new int[] {100,180,140,170,220};
			int weight[] = new int[]  {20,60,20,85,40};
			int result = Engrave.cupSelection(weight, value,170,  5);
			assertEquals(640, result, "640 expected but "+ result+ "is given");
	}
	
	@Test
	void CupSelectiontest7() {
			int value[] = new int[] {100,180,140,170,220};
			int weight[] = new int[]  {20,60,20,85,40};
			int result = Engrave.cupSelection(weight, value,110,  5);
			assertEquals(460, result, "460 expected but "+ result+ "is given");
	}
	
	@Test
	void drawIntervalTest1() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		expected.add("[3]"); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		Engrave e = new Engrave();
		e.drawIntervals(3);
		boolean equal = true; 
		if (expected.size() == e.drawnObject.size()) {
			for (int i = 0; i < expected.size(); i++)
				if (expected.get(i).compareTo(e.drawnObject.get(i)) != 0) {
					equal = false;
					break;
				}
			
		}
		else 
			equal = false;
		assertEquals(true, equal, "drawIntervals(3) is not correct");
	}
	@Test
	void drawIntervalTest3() {
		Engrave e = new Engrave();
		e.drawIntervals(1);
		boolean equal = (e.drawnObject.size() == 1 && e.drawnObject.get(0).compareTo("[1]") == 0); 
		assertEquals(true, equal, "drawIntervals(1) is not correct");
	}
	@Test
	void engraveTest1() {
		Engrave e = new Engrave();
		e.engrave(5, 0);
		boolean equal = (e.drawnObject.size()== 1 && e.drawnObject.get(0).compareTo("[5, 0]") == 0); 
		assertEquals(true, equal, "engrave(5, 0) is not correct");
	}
	@Test
	void engraveTest2() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[2, 3]"); 
		expected.add("[1]"); 
		expected.add("[2, 2]"); 
		expected.add("[1]"); 
		expected.add("[2, 1]"); 
		expected.add("[1]"); 
		expected.add("[2, 0]");
		Engrave e = new Engrave();
		e.engrave(2, 3);
		boolean equal = e.drawnObject.size()== 7;
		if (equal) {
			for (int i = 0; i < expected.size(); i++)
				if (expected.get(i).compareTo(e.drawnObject.get(i)) != 0) {
					equal = false;
					break;
				}
			
		}

		assertEquals(true, equal, "engrave(2, 3) is not correct");
	}


	@Test
	void engraveTest4() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[0, 3]"); 
		expected.add("[0, 2]"); 
		expected.add("[0, 1]"); 
		expected.add("[0, 0]");

		Engrave e = new Engrave();
		e.engrave(0, 3);
		boolean equal = e.drawnObject.size() == 4;
		if (equal) {
			for (int i = 0; i < expected.size(); i++)
				if (expected.get(i).compareTo(e.drawnObject.get(i)) != 0) {
					equal = false;
					break;
				}
		}
		assertEquals(true, equal, "engrave(0, 3) is not correct");
	}
	

}
