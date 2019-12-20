package ua.khpi.oop.mishchenko02;
import java.util.Random;

public class MaxDigit {
 
	
	
	public static void main(String[] args) {

		
		int number = 0;
		System.out.println("-----------------------------");
		System.out.println("|  Number  |   Max digit    |");
		System.out.println("-----------------------------");
		for(int i = 0; i < 10; i++) {
			number = Generator(100 + 1,1000);
			System.out.print("|   " + number + "    |" );
			System.out.print("        " + MaxDigitFinder(number)+ "       |\n");
			System.out.print("-----------------------------\n");
		}
		
	}
	
	static int Generator(int min_range, int max_range) {
		Random temp = new Random();
		int number = temp.nextInt(max_range - min_range);
		number += min_range;
		return number;
	}
	
	
	static int MaxDigitFinder(int number) {
	int max = 0;

	while(number != 0) {
		if(max < (number % 10)) {
			max = number % 10;	
		}
		number = number / 10;
	}
		return max;
	}
	

	
}
