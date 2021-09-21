package Lab1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(Lab.getMyID());
		double x= sc.nextDouble();
		while(x!=111) {
			System.out.println(Lab.getLetterGrade(x));
			x= sc.nextDouble();
		}
		sc.close();
	}

}
