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
		e.drawLine (6, ' ');
		boolean equal = e.charPrintCount == 8; 
		assertEquals(true, equal, "drawLine (6, ' ') is not correct");
	}
	@Test
	void drawLineTest3() {
		Engrave e = new Engrave();
		e.drawLine (5, '3');
		boolean equal = e.charPrintCount == 7; 
		assertEquals(true, equal, "drawLine (5, '3'); is not correct");
	}
	@Test
	void drawLineTest4() {
		Engrave e = new Engrave();
		e.drawLine (0, 'A');
		boolean equal = e.charPrintCount == 2; 
		assertEquals(true, equal, "drawLine (0, 'A'); is not correct");
	}
	@Test
	void drawLineTest5() {
		Engrave e = new Engrave();
		e.drawLine (-1, 'A');
		boolean equal = e.charPrintCount == 0; 
		assertEquals(true, equal, "drawLine (-1, 'A'); is not correct");
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
			int value[] = new int[0] ;
			int weight[] = new int[0];
			int result = Engrave.cupSelection(weight, value,50,  0);
			assertEquals(0, result, "0 expected but "+ result+ "is given");
	}
	@Test
	void CupSelectiontest3() {
		    int value[] = new int[] {60, 120, 100 , 100, 30 , 20};
		    int weight[] = new int[]  {10, 30,  20  , 20,  30 , 10};
		    int result = Engrave.cupSelection(weight, value,50,  6);
			assertEquals(260, result, "260 expected but "+ result+ "is given");
	}
	@Test
	void CupSelectiontest4() {
			int value[] = new int[] {60, 50, 20};
			int weight[] = new int[]  {30,  30 , 10};
			int result = Engrave.cupSelection(weight, value,500,  3);
			assertEquals(130, result, "130 expected but "+ result+ "is given");
	}
	@Test
	void CupSelectiontest5() {
			int value[] = new int[] {60, 50, 20};
			int weight[] = new int[]  {30,  30 , 10};
			int result = Engrave.cupSelection(weight, value,5,  3);
			assertEquals(0, result, "0 expected but "+ result+ "is given");
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
	void drawIntervalTest2() {
		Engrave e = new Engrave();
		e.drawIntervals(0);
		boolean equal = e.drawnObject.size() == 0; 
		assertEquals(true, equal, "drawIntervals(0) is not correct");
	}
	@Test
	void drawIntervalTest3() {
		Engrave e = new Engrave();
		e.drawIntervals(1);
		boolean equal = (e.drawnObject.size() == 1 && e.drawnObject.get(0).compareTo("[1]") == 0); 
		assertEquals(true, equal, "drawIntervals(1) is not correct");
	}
	@Test
	void drawIntervalTest4() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		expected.add("[3]"); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		expected.add("[4]");
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		expected.add("[3]"); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 	
		Engrave e = new Engrave();
		e.drawIntervals(4);
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

		assertEquals(true, equal, "drawIntervals(4) is not correct");
	}
	@Test
	void drawIntervalTest5() {
		Engrave e = new Engrave();
		e.drawIntervals(-1);
		boolean equal = e.drawnObject.size()== 0; 
		assertEquals(true, equal, "drawIntervals(-1) is not correct");
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
		System.out.println("_____"+e.charPrintCount);
		assertEquals(true, equal, "engrave(2, 3) is not correct");
	}

	@Test
	void engraveTest3() {
		Engrave e = new Engrave();
		e.engrave(2, -3);
		boolean equal = e.drawnObject.size() == 0;

		assertEquals(true, equal, "engrave(2, -3) is not correct");
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
	
	@Test
	void engraveTest5() {

		Engrave e = new Engrave();
		e.engrave(-2, 3);
		boolean equal = e.drawnObject.size() == 0;
		assertEquals(true, equal, "engrave(-2, 3) is not correct");
	}

}
