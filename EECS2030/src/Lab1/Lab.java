package Lab1;
/**
 * This is Lab1 For EECS2030 Section A
 * @author Hoshner Tavadia
 * @version 1.00
 * 
 */
public class Lab {
	/**
	 * getMyId returns my student ID
	 * @return the output will be a string of my 9 digit student ID
	 */
	public static String getMyID() {
		String ID = "217828567";
		return ID;
	}
	
	/**
	 * Accepts a double value and outputs a letter grade based on the input
	 * @param per is the input percentage that you need to return the grade should be between 0 and 100
	 * @return will return a grade based on the input given
	 */
	public static String getLetterGrade(double per) {
		if(per>=90)
            return "A+";
        else if(per<90 && per>=80)
            return "A";
        else if(per<80 && per>=75)
            return "B+";
        else if(per<75 && per>=70)
            return "B";
        else if(per<70 && per>=65)
            return "C+";
        else if(per<65 && per>=60)
            return "C";
        else if(per<60 && per>=55)
            return "D+";
        else if(per<55 && per>=50)
            return "D";
        else if(per<50 && per>=45)
            return "E";
        else
            return "F";
	}
}
