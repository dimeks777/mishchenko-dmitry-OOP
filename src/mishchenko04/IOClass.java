package ua.khpi.oop.mishchenko004;

import java.util.Scanner;
import java.util.ListIterator;
public class IOClass {
  static String str_input() {
    System.out.println("Enter some sentences:");
	@SuppressWarnings("resource")
	String user_str = new Scanner(System.in).nextLine();
	return user_str;
}

  static void list_printer(LinkedList<String> sentences) {
	int count = 1;
	ListIterator<String> it = sentences.listIterator();
	while(it.hasNext()) {
		String value = it.next();
		System.out.println(count+". " + value);
		count++;
	}
}
  
  static void cls() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	static void printInfo() {
		System.out.println("---------------------------------------------------------------About program---------------------------------------------------------------\n");
		
		System.out.println("@File 	     Main.java");
		System.out.println("@Task        Ввести текст. Текст розбити на речення.\n\t     Для кожного речення знайти та надрукувати всi слова максимальної та всi слова мiнiмальної довжини. \n\t     Результат вивести у виглядi таблицi. ");
		System.out.println("@Author	     Dmitry Mishchenko");
		System.out.println("@Version     0.1.0");
		System.out.println("@Date        31.10.2019");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------\n\n\n");
		
	}
	
	 static void printMenu() {
	        System.out.println("1. Data operations");
	        System.out.println("2. Show data");
	        System.out.println("3. Start analysing");
	        System.out.println("4. Using StringBuilder");
	        System.out.println("5. Exit");
	 }

}
