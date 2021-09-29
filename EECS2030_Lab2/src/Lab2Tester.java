

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;





@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab2Tester {

	
	// sum
	
	@Test
	public void testSum1() {
		int start = 0;
		int end = 5; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	

	@Test
	public void testMakeString1() {
		char init = '*'; 
		int n = 5;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}

	
	@Test
	public void testInterlace2() {

		String str = "*";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("*","-",1));
	}
	
	@Test
	public void testInterlace1() {

		String str = "";
		assertEquals("Failed: interlace(\"*\",\"-\",0)", str, Lab2.interlace("*","-",0));
	}
	
	@Test
	public void testInterlace3() {

		String str = "Hello World Hello ";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("Hello ","World ", 3));
	}

	

	@Test
	public void testGetSubstring1() {

		String str1 = "x + y + z - ( y * z) / 3 * n ";
		String result = " y * z";
		char open = '(';
		char close = ')';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("x + y + z - ( y * z) / 3 * n ", '(', ')'));
	}
	
	@Test
	public void testGetCharPosition1() {

		String str1 = "ABCDEFG";
		int result = 6;
		char open = 'G';
		assertEquals("Failed", result, Lab2.getCharPosition(str1,open,0,str1.length()));
	}
	
	@Test
	public void testGetCharPosition2() {

		String str1 = "ABCDEFG";
		int result = -1;
		char open = 'X';
		assertEquals("Failed", result, Lab2.getCharPosition(str1,open,0,str1.length()));
	}
	
	@Test
	public void testGetChars1() {

		String str1 = "ABCDEFG";
		String result = "CDE";
		assertEquals("Failed", result, Lab2.getChars(str1,1,5,0));
	}

	@Test
	public void testDecimalToBinary2() {
		int decimal = 23; 
		String binary = "10111";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(23));
	}
	
	@Test
	public void testDecimalToBinary1() {
		int decimal = 64; 
		String binary = "1000000";
		assertEquals("Failed: decimalToBinary(64)", binary, Lab2.decimalToBinary(64));
	}
	
	@Test
	public void testDecimalToBinary3() {
		int decimal = 217828567; 
		String binary = "1100111110111100110011010111";
		assertEquals("Failed: decimalToBinary(64)", binary, Lab2.decimalToBinary(decimal));
	}

}