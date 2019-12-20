package ua.khpi.oop.mishchenko06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Scanner;

import ua.khpi.oop.kononenko05.Helper;


public class Main {
	/*
	static public void saveContainer(LinkedList<String> a) throws IOException {
   
		  PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dimek\\eclipse-workspace\\mishchenko-dmitry\\bin\\ua\\khpi\\oop\\mishchenko06\\savedData.txt"), true);
          
          for (String str : a)
          {
               out.println(str);
          }
          out.close();
	  }
	*/
	
	static public void saveContainer(LinkedList<String> a) throws IOException {
	 ObjectOutputStream objectOutputStream = new ObjectOutputStream
	(new FileOutputStream("C:\\Users\\dimek\\eclipse-workspace\\mishchenko-dmitry\\bin\\ua\\khpi\\oop\\mishchenko06\\savedData2.txt"));
     objectOutputStream.writeObject(a);
     objectOutputStream.close();
	}
	

	@SuppressWarnings("unchecked")
	static public LinkedList<String> recoverContainer() throws IOException, ClassNotFoundException {
	@SuppressWarnings("resource")
	ObjectInputStream in = new ObjectInputStream
	(new FileInputStream("C:\\Users\\dimek\\eclipse-workspace\\mishchenko-dmitry\\bin\\ua\\khpi\\oop\\mishchenko06\\savedData2.txt"));
    return (LinkedList<String>)in.readObject();
    
     }
	 
	 /*
	     public static LinkedList<String> recoverContainer() throws IOException, ParseException
	     {
	          LinkedList<String> list = new LinkedList<String>();
	          BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\dimek\\eclipse-workspace\\mishchenko-dmitry\\bin\\ua\\khpi\\oop\\mishchenko06\\savedData.txt"));
	          String buf;
	          while ((buf = in.readLine()) != null)
	          {          
	               list.add(buf);
	          }
	          return list;
	     }
	     */
public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
	boolean help = false;
	
	boolean debugMode = false;
	for(String s1: args) {
		if((s1.equals("-h")||s1.equals("-help")) && (!help)) {
			
			help = true;
		}
		if((s1.equals("-d")||s1.equals("-debug")) && (!debugMode)) {
			
			debugMode = true;
		}
	}
	
	Scanner scan = new Scanner(System.in);
     int x = 0;
     String s ="";
     

   
    String text = new String();
    text = "Every story has a beginning and an end. "
 			+ "Each story has its own outline, synopsis, content, key points, prologues and epilogues. "
 			+ "And there is no such book in which with each new reading things, that had not been paid attention to before,"
 			+ "would not be revealed. "
 		    + "Every story has a beginning and an end. "
 			+ "Almost every ...";
    
    LinkedList<String> q =  new LinkedList<String>();
    q.add(text);
     while (!"5".equals(s)){
    	 if(debugMode) {
    		 System.out.println("Debug mode activated\n\n");
    	 }
    	 if(help) {
    	 IOClass.printInfo();
    	 }
         IOClass.printMenu();
         s = scan.next();     
         try {
             x = Integer.parseInt(s);
         } catch (NumberFormatException e){
             System.out.println("Incorrect input");
         }
         
         switch (x){
             case 1:
            	 int y = 0;
            	System.out.println("Select input:");
            	System.out.println("1. Add data");
            	System.out.println("2. Delete selected data");
            	System.out.println("3. Delete all");
            	System.out.println("4. Replace data");
            	System.out.println("5. Save container");
            	System.out.println("6. Load container");
            	System.out.println("7. Sort");
            	System.out.println("8. Search");
            	System.out.println("9. Using compiled class (student Kononenko)");
            	System.out.println("10.Back");
            	
            	 y = scan.nextInt();
            	 
            	
            	 switch(y) {
            	 	case 1:
            	 	{
            	 		
            	 		int add = 0;
            	 		
            	 		System.out.println("Insert option:");
            	 		System.out.println("1. Add default");
            	 		System.out.println("2. Input from keyboard");
            	 		System.out.println("3. Back");
            	 		add = scan.nextInt();
            	 		switch(add) {
            	 		case 1:
            	 			text = "Every story has a beginning and an end. "
                    	 			+ "Each story has its own outline, synopsis, content, key points, prologues and epilogues. "
                    	 			+ "And there is no such book in which with each new reading things, that had not been paid attention to before,"
                    	 			+ "would not be revealed. "
                    	 		    + "Every story has a beginning and an end. "
                    	 			+ "Almost every ...";
            	 			q.add(text);
            	 			break;
						case 2:
            	 			text = IOClass.str_input();
            	 			q.add(text);
                	 		break;
						case 3:
							break;
            	 		}	
            	 		break;
            	 	}
            	 	case 2:{
            	 		System.out.println("Enter number of string to delete");
            	 		IOClass.list_printer(q);
            	 		int i = scan.nextInt();
            	 		if(!(i > q.size() - 1)) {
            	 		q.remove(i-1);
            	 		}else {
            	 			System.out.println("Out of array index");
            	 		}
            	 		break;
            	 	}
            	 	case 3:{
            	 		q.clear();
            	 		break;
            	 	}
            	 	case 4:{
            	 		text = IOClass.str_input();
            	 		System.out.println("Enter number of string to replace:");
            	 		IOClass.list_printer(q);
            	 		int i = scan.nextInt();
            	 		if(!(i > q.size() - 1)) {
            	 		q.set(i-1, text);
            	 		}else {
            	 			System.out.println("Out of array index");
            	 		}
            	 		break;
            	 	}
            	 	
            	 	case 5:
            	 		saveContainer(q);
            	 		break;
            	     
            	 	case 6:
            	 		q = recoverContainer();
            	 		break;
            	 	case 7:
            	 		q.sort(null);     
            	 		break;
            	 	case 8:
            	 		System.out.println("Enter a string to search");
            	 		String search = IOClass.str_input();
            	 		int index = 0;
            	 		index = q.indexOf(search);
            	 		if(index > 0) {
            	 			System.out.println("Your string is on " + (index+1) + "place");
            	 		}else {
            	 			System.out.println("No such string");
            	 		}
            	 		break;
            	 		
            	 	case 9:
            	 		System.out.println("Enter number of string to analise:");
            	 		IOClass.list_printer(q);
            	 		int choice = scan.nextInt();
            	 		Helper a = new Helper();
            	 		a.Parse(q.get(choice-1));
            	 		a.Print_result();
            	 		Helper.Print_info();
            	 		System.out.println("Press Any Key To Continue...");
                        new java.util.Scanner(System.in).nextLine();
            	 		break;
            	 }
            	 	
            	 	
            	 System.out.println("Press Any Key To Continue...");
                 new java.util.Scanner(System.in).nextLine();
            	 break;
             case 2:
            	 System.out.println("Your data:");
            	IOClass.list_printer(q);
            	System.out.println("Press Any Key To Continue...");
                new java.util.Scanner(System.in).nextLine();
            	 break;
             case 3:
            	 System.out.println("Enter number of string to analise:");
            	 IOClass.list_printer(q);
            	 int choice = scan.nextInt();
            	 TextAnaliser first = new TextAnaliser(q.get(choice-1));
            	 first.sentences_splitter();
            	 if(debugMode) {
            		 System.out.println("\n\n-------------------Result of splitting into sentences:-------------------\n\n");
            		 System.out.println("Count of sentences: " + first.list_of_sentences.size() + "\n\n");
            		 IOClass.list_printer(first.list_of_sentences);
            		 System.out.println("-------------------------------------------------------------------------\n\n");
            		 System.out.println("Press Any Key To Continue...");
                     new java.util.Scanner(System.in).nextLine();
                   
                     
            	 }
            	 first.word_splitter(debugMode);
                
            	 System.out.println("Press Any Key To Continue...");
            	 
                 new java.util.Scanner(System.in).nextLine();
                 break;
             case 4:
            	 StringBuilder str = new StringBuilder("StringBuilder is being used");
           	  str.delete(str.indexOf("is"),str.indexOf("is")+3);
           	  str.insert(str.indexOf(" "), " is not");
           	  System.out.println(str);
           	System.out.println("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
           	  break;
         }
         
         IOClass.cls();
     }
     scan.close();
	
	
  
}
}
