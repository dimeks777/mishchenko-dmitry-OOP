package ua.khpi.oop.mishchenko03;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class IOClass {
  static String str_input() {
    System.out.println("Enter some sentences:");
	Scanner user_input = new Scanner(System.in);
	String user_str = user_input.nextLine();
	user_input.close();
	System.out.println("Input channel is closed\n\n");
	return user_str;
}

  static void list_printer(LinkedList<String> sentences) {
	Iterator<String> it = sentences.iterator();
	while(it.hasNext()) {
		String value = it.next();
		System.out.println(value);
	}
}

}
