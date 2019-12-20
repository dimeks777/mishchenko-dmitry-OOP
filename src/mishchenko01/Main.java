package ua.khpi.oop.mishchenko01;

public class Main {

	public static void main(String[] args ) {
		final int ZACHETKA = 0x467A;
		System.out.println(ZACHETKA);
		Counter.evenCount(ZACHETKA);
		Counter.oddCount(ZACHETKA);
		Counter.zeroCount(ZACHETKA);
		Counter.binaryOneCount(ZACHETKA);
		System.out.println();
		final long NUMBER = 380509395987l;
		System.out.println(NUMBER);
		Counter.evenCount(NUMBER);
		Counter.oddCount(NUMBER);
		Counter.zeroCount(NUMBER);
		Counter.binaryOneCount(NUMBER);
		System.out.println();
		final byte BINARY = 0b1010111;
		System.out.println(BINARY);
		Counter.evenCount(BINARY);
		Counter.oddCount(BINARY);
		Counter.zeroCount(BINARY);
		Counter.binaryOneCount(BINARY);
		System.out.println();
		final int OCTAL = 013543;
		System.out.println(OCTAL);
		Counter.evenCount(OCTAL);
		Counter.oddCount(OCTAL);
		Counter.zeroCount(OCTAL);
		Counter.binaryOneCount(OCTAL);
		System.out.println();
		final int magickNumber = ((13-1)%26)+1;
		System.out.println(magickNumber);
		Counter.evenCount(magickNumber);
		Counter.oddCount(magickNumber);
		Counter.zeroCount(magickNumber);
		Counter.binaryOneCount(magickNumber);
		System.out.println();
		final char magickCharacter = 77;
		System.out.println(magickCharacter);
		Counter.evenCount((int)magickCharacter);
		Counter.oddCount((int)magickCharacter);
		Counter.zeroCount((int)magickCharacter);
		Counter.binaryOneCount((int)magickCharacter);
		System.out.println();
	}
}
