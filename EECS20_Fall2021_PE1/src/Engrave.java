
import java.util.ArrayList;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Hoshner Tavadia
Student Number:217828567
Course Section:EECS2030 Section A
*/


/**
 * This class engraves the measures on a measuring cup. 
 * @author Hoshner Tavadia
 * Student ID: 217828567
 * Email: htavadia@my.yorku.ca
 */

public class Engrave {
	public ArrayList<String> drawnObject; 
	int charPrintCount; 

	/**
	 * Constructor Class of the Java FIle Engrave, it initializes an String array to store all the engraving data and also initializes the charPrintCount variable to zero.
	 */
	public Engrave() {
		drawnObject = new ArrayList<String>(); 
		charPrintCount = 0;
	}
	
	/**
	 * Is the main method that calls upon drawIntervals() and drawLine(), it prints out the main intervals that needs to be engraved on the measuring cups.
	 * @param tickLength is  the  number  of  dashes  that  is printed next to the numbers.
	 * @param magnitude points  to  the  capacity  of  the  cup. It is the main factor that decides how many intervals need to be drawn and what would the magnitude of the measurement be. 
	 * @pre magnitude>=0
	 */
	
	public void engrave(int tickLength, int magnitude) {
		if(magnitude>0) {
			this.drawnObject.add("["+tickLength+", "+magnitude+"]");
			this.drawLine(tickLength, (char)(magnitude+'0'));
			this.drawIntervals(tickLength-1);
			this.engrave(tickLength, magnitude-1);
		}
		else if (magnitude==0) {
			this.drawnObject.add("["+tickLength+", 0]");
			this.drawLine(tickLength, (char)(48+magnitude));
		}
	}
	
	/**
	 * This method prints  the  intervals  between  two  major lines, the length of the major line is given below.
	 * @param tickLength is the length of the the highest/biggest interval lines.
	 */
	public void drawIntervals(int tickLength) {
		if(tickLength>1) {
			this.drawIntervals(tickLength-1);
			this.drawLine(tickLength,' ');
			this.drawnObject.add("["+tickLength+"]");
			this.drawIntervals(tickLength-1);
		}
		else if(tickLength==1) {
			this.drawLine(1,' ');
			this.drawnObject.add("[1]");
		}
	}
	
	/**
	 * This method draws a line using dash (-) character [i.e., minus sign] followed by the space character " " and a label of one single character. It also is used to keep track of the total number of characters engraved with the help of the counter.
	 * @param tickLength is the length of the '-' characters you want to add
	 * @param tickLabel is the label that should be added after the line is drawn
	 */
	public void drawLine (int tickLength, char tickLabel) {
		if(tickLength==0) {
			System.out.print(" "+tickLabel);
			System.out.println();
			this.charPrintCount+=2;
		}			
		else {
			System.out.print("-");
			this.charPrintCount++;
			this.drawLine(tickLength-1, tickLabel);
		}
	}
	
	/**
	 * This method is used to find the most suitable combination of the measuring cups given to stay within the maximum weight restriction is not crossed. The function is made to choose the weights that will maximize the selling price.
	 * @param weight is an array of all the weights of each measuring cup.
	 * @param value is the array of all the values of each measuring cup.
	 * @param maxWeight is the maximum weight that should  not be exceeded.
	 * @param index is the counter of the total number of items in the weight and value arrays, it determines how many times the function goes into recursion.
	 * @return is the total of all the values of the chosen measuring cups.
	 */
	public static int cupSelection(int weight[], int value[], int maxWeight, int index) {
		double rate[] = new double[weight.length];
		rate = Engrave.getRate(weight, value, rate, weight.length);	//calls getRate() which creates an array of all the ratios between the value and the weight, hence it gives a value per weight.
		int max = getMax(rate, weight, 0, rate.length-1);//calls getMax() that returns the index value of the the the measuring cup with the highest value/weight rate.
		if(index>0 && maxWeight>0) {
			Boolean f = false;
			if(weight[max]<=maxWeight) {
				f = true;
			}
			if(f) {
				maxWeight -= weight[max];
				int val = value[max];
				weight[max]=100000;
				value[max]=1;
				return cupSelection(weight,value,maxWeight,index)+val;
			}
			else {
				weight[max]=0;
				value[max]=0;
				return cupSelection(weight,value,maxWeight,index-1)+0;
			}
			
			
		}
		return 0;
     }
	
	//private method that returns the value/weight ratios of all the measuring cups in an array.
	private static double[] getRate(int[] weight, int[] value,double[] rate, int index) {
		if(index>0) {
			rate[index-1] = (double) value[index-1] / weight[index-1];
			return getRate(weight,value,rate,index-1);
		}
		return rate;
	}

	//private method that returns the index number of the measuring cup with the highest value/weight ratio or rate.
	private static int getMax(double[] rate,int[] weight, int max, int index) {
		if(index>=0) {
			if(rate[max]<rate[index]) {
				max = index;
			}
			else if(rate[max]==rate[index] && weight[max]<weight[index]) {
				max = index;
			}
			return getMax(rate,weight,max,index-1);
		}
		else 
			return max;
	}
	
	
  

}
