package ua.khpi.oop.mishchenko01;

public class Counter {
    
	public static void evenCount(long number) {
    	int count = 0;
    	long rest = 0;
    	System.out.print("Counter of even digits in number " + number + " equals: ");
    	while(number !=0) {
    		rest = number % 10;
    		number = number / 10;
    		if(rest % 2 == 0 && rest != 0 ) {
    			count++;
    		}
    	}
    	System.out.println(count);
    }
	
	
	public static void evenCount(int number) {
    	int count = 0;
    	int rest = 0;
    	System.out.print("Counter of even digits in number " + number + " equals: ");
    	while(number !=0) {
    		rest = number % 10;
    		number = number / 10;
    		if(rest %2 == 0 && rest != 0 ) {
    			count++;
    		}
    	}
    	System.out.println(count);
    }
	
	
	public static void oddCount(long number) {
    	int count = 0;
    	long rest = 0;
    	System.out.print("Counter of odd digits in number " + number + " equals: ");
    	while(number !=0) {
    		rest = number % 10;
    		number = number/10;
    		if(rest % 2 != 0 && rest != 0) {
    			count++;
    		}
    	}
    	System.out.println(count);
    }
	
	
	public static void oddCount(int number) {
    	int count = 0;
    	int rest = 0;
    	System.out.print("Counter of odd digits in number " + number + " equals: ");
    	while(number !=0) {
    		rest = number%10;
    		number = number/10;
    		if(rest % 2 != 0 && rest != 0) {
    			count++;
    		}
    	}
    	System.out.println(count);
    }
	
	public static void zeroCount(long number) {
		int count = 0;
    	long rest = 0;
    	System.out.print("Counter of zero digits in number " + number + " equals: ");
    	while(number !=0) {
    		rest = number % 10;
    		number = number/10;
    		if(rest == 0) {
    			count++;
    		}
    	}
    	System.out.println(count);
		
	}
	
	public static void zeroCount(int number) {
		int count = 0;
    	int rest = 0;
    	System.out.print("Counter of zero digits in number " + number + " equals: ");
    	while(number !=0) {
    		rest = number % 10;
    		number = number/10;
    		if(rest == 0) {
    			count++;
    		}
    	}
    	System.out.println(count);
		
	}
	
	public static void binaryOneCount(int number) {
		int count = 0;
		char temp = 0;
		String binaryCode = Integer.toBinaryString(number);
		System.out.println(binaryCode);
		System.out.print("Counter of binary's one digits in number " + number + " equals: ");
		for(int i = 0; i < binaryCode.length(); i++) {
			temp = binaryCode.charAt(i);
			if(temp == '1') {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	public static void binaryOneCount(long number) {
		int count = 0;
		char temp = 0;
		String binaryCode = Long.toBinaryString(number);
		System.out.println(binaryCode);
		System.out.print("Counter of binary's one digits in number " + number + " equals: ");
		for(int i = 0; i < binaryCode.length(); i++) {
			temp = binaryCode.charAt(i);
			if(temp == '1') {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	
}
