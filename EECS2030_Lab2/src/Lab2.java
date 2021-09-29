


/**
 * A utility class containing several recursive methods (Lab 2, F 2021)
 * 
 * <pre>
 * 
 * For all methods in this API, you are forbidden to use any loops, 
 * String or List based methods such as "contains", or methods that use regular expressions
 * </pre>
 * 
 * @author EECS2030 Fall 2021
 *
 */
public final class Lab2 {
	
	/**
	 * This is empty by design, Lab2 cannot be instantiated 
	 */
	private Lab2() {
		// empty by design
	}

			  

	/**
	 * Returns the sum of a consecutive set of numbers from <code> start </code> to <code> end </code>. 
	 * 
	 * @pre <code> start </code> and <code> end </code>  are small enough to let this  
	 * method return an int. This means the return value at most requires 4 bytes and 
	 * no overflow would happen.  
	 * 
	 * @param start is an integer number
	 * @param end is an integer number
	 * @return the sum of start + (start + 1) + .... + end
	 */
	public static int sum(int start, int end) {
		// write your code here
		// you may want to change the return value. 
		if(start>end) {
			return 0;
		}
		return start + sum(start+1,end);

	}

	/**
	 * This method creates a string using the given char
	 * by repeating the character <code> n </code> times.
	 * 
	 * @param first is the given character by which the string is made.
	 * @param n is the number of characters in the final string
	 * @return a string made of the given character. 
	 * 
	 * @pre n is not negative.
	 */
	public static String makeString(char first, int n) {
		// Write your code here. 
		// you may want to change the return value.
		if(n==0) {
			return "";
		}
		return first+makeString(first,--n);
	}

	/**
	 * This method gets two strings and interlace a string using the 
	 * these two input strings. The number of words in the returned string is as much 
	 * as the value of the third input parameter.
	 * 
	 * @param first is the string that is used in the even position of the returned result [asuming
	 * that the position starts from zero]
	 * @param second is the string that is used in the odd position of the returned result
	 * @param n is the number of letters in the returned result.
	 * @return returns a string made of the first and the second input parameter. 
	 */
	public static String interlace(String first, String second, int n) {

		// Write your code here. 
		// you may want to change the return value.
		if(n==0) {
			return "";
		}
		else if(n%2==0) {
			return interlace(first,second,--n)+second;
		}
		else {
			return interlace(first,second,--n)+first;
		}
	}

	/**
	 * This method returns a substring of the given input string that is enclosed in two 
	 * given characters. 
	 * @param str is a string that contains at least two characters including <code> open </code> and <code> close </code> 
	 * @param open is a character at the beginning of the string that should be returned. 
	 * @param close is a character at the end of the string that should be returned.
	 * @return returns a string enclosed in two given characters of <code> open </code> and <code> close </code>.
	 * @pre The given str contains only one <code> open </code> and one <code> close </code> character.
	 */
	public static String getSubstring(String str, char open, char close) {
		// Write your code here. 
		// you may want to change the return value.
		int s = getCharPosition(str,open,0,str.length());
		int e = getCharPosition(str,close,0,str.length());		
		return getChars(str,s,e,0);

	}
	public static int getCharPosition(String str, char c, int n, int l) {
		if(n==l) {
			return -1;
		}
		else  if(str.charAt(n)==c) {
			return n;
		}
		return getCharPosition(str, c, ++n, l);
	}
	
	public static String getChars(String str,int s,int e,int n) {
		if(n>s && n<e) {
			return str.charAt(n)+getChars(str,s,e,++n);
		}
		else if(n<str.length()) {
			return getChars(str,s,e,++n);
		}
		return "";
	}
	
	/**
	 * This method converts a decimal value into its binary representation. 
	 * @param value is a positive integer number
	 * @return the binary representation of the input.
	 * @pre the input is a positive integer number. 
	 */
	
	public static String decimalToBinary(int value) {
		
		// Write your code here. 
		// you may want to change the return value.
		if(value==0) {
			return "";
		}
		else if(value%2==0) {
			return decimalToBinary(value/2)+"0";
		}
		return decimalToBinary(value/2)+"1";
	}
}

