package ua.khpi.oop.mishchenko08;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Menu {

	@SuppressWarnings("resource")
	static void launch() throws FileNotFoundException {
		
		System.out.println("Добро пожаловать!");
		ArrayList<Hotel> clients = new ArrayList<Hotel>();
		Scanner scan = new Scanner(System.in);
		int x = 0;
	    String mainMenu ="";
	    
	    
	    while (!"6".equals(mainMenu)){
	    	
	    	 Interface.printMenu();
	    	 mainMenu = scan.next();     
	         try {
	             x = Integer.parseInt(mainMenu);
	         } catch (NumberFormatException e){
	             System.out.println("Неверный формат данных");
	         }
	         
	         
	         
	         
	         switch (x){
	         	
	         	case 1:
	         		String add = ""; 
	         		int y = 0;
	         		int passportNumber = 0;
	         		String surname = new String("1");
	         		String name = new String("1");
	         		String patronymic = new String("1");
	         		GregorianCalendar settlementDate = new GregorianCalendar(2000, Calendar.JANUARY , 1);
	         		GregorianCalendar evictionDate = new GregorianCalendar(2000, Calendar.JANUARY , 1);
	         		int numberOfRoom = 0;
	        		String classOfRoom = new String("1");
	        		int countOfPlaces = 0;
	         		ArrayList<String> settlementReason = new ArrayList<String>();
	         		
	        	 while(!"0".equals(add)){
	        		 Interface.printInputInterface();
	        		 add = scan.next();     
	    	         try {
	    	             y = Integer.parseInt(add);
	    	         } catch (NumberFormatException e){
	    	             System.out.println("Неверный формат данных");
	    	         }
	    	         
	    	         switch(y) {
	    	         case 1:
	    	        	 passportNumber = Interface.inInt();
	    	        	 break;
	    	         case 2:
	    	        	 surname = Interface.inStr();
	    	        	 break;
	    	        	 
	    	         case 3:
	    	        	 name = Interface.inStr();
	    	        	 break;
	    	        	 
	    	         case 4:
	    	        	 patronymic = Interface.inStr();
	    	        	 break;
	    	        	 
	    	         case 5:
	    	        	 settlementDate = Interface.inCalendar();
	    	        	 break;
	    	        	 
	    	         case 6:
	    	        	 evictionDate = Interface.inCalendar();
	    	        	 break;
	    	        	 
	    	         case 7:
	    	        	 numberOfRoom = Interface.inInt();
	    	        	 break;
	    	        	 
	    	         case 8:
	    	        	 classOfRoom = Interface.inStr();
	    	        	 break;
	    	        	 
	    	         case 9:
	    	        	 countOfPlaces = Interface.inInt();
	    	        	 break;
	    	        	 
	    	         case 10:
	    	        	 settlementReason.add(Interface.inStr());
	    	        	 break;
	    	        	 
	    	         case 11:
	    	        	 
	    	        	 Interface.showData(passportNumber,surname,name,patronymic,settlementDate,evictionDate,numberOfRoom,classOfRoom,countOfPlaces,settlementReason);
	    	        	 System.out.println("Нажмите любую клавишу для продолжения...");
	    	             new java.util.Scanner(System.in).nextLine();
	    	        	break;
	    	        	 			
	    	         case 12:
	    	        	 clients.add(new Hotel(passportNumber,surname,name,patronymic,settlementDate,evictionDate,
	    	        			 new HotelRoom(numberOfRoom,classOfRoom,countOfPlaces),settlementReason));
	    	        	 			break;
	    	        	 
	    	        	 
	    	         }
	    	         Interface.cls();
	        	 }
	        	 
	        	 break;
	        	 
	        	 
	         	case 2:
	         		Interface.showArray(clients);
	         		System.out.println("Введите индекс клиента для удаления");
	         		int index = Interface.inInt();
	         		clients.remove(index-1);
	         		break;
	         		
	         	case 3:
	         		clients.clear();
	         		System.out.println("Нажмите любую клавишу для продолжения...");
   	             new java.util.Scanner(System.in).nextLine();
	         		break;
	         		
	         	case 4:
	         		Interface.showArray(clients);
	         		System.out.println("Нажмите любую клавишу для продолжения...");
   	             new java.util.Scanner(System.in).nextLine();
	         		break;
	         		
	         	case 5:
	         		String xml = ""; 
	         		int z = 0;
	         		Interface.printXmlMenu();
	         		String path = "C:\\Users\\dimek\\eclipse-workspace\\mishchenko-dmitry";
	         		xml = scan.next();     
	    	         try {
	    	             z = Integer.parseInt(xml);
	    	         } catch (NumberFormatException e){
	    	             System.out.println("Неверный формат данных");
	    	         }
	    	         switch(z) {
	    	         
	    	         case 1:
	    	        	 String find = "";
	    	        	 int k = 0;
	    	        	 while(!"0".equals(find)) {
	    	        	   	 System.out.println("Текущий путь: " + path);
	    	        		 Interface.printFileChooseMenu();
	    	        		 find = scan.next();
	    	        		 try {
			    	             k = Integer.parseInt(find);
			    	         } catch (NumberFormatException e){
			    	             System.out.println("Неверный формат данных");
			    	         }
	    	        		 
	    	        		 switch(k) {
	    	        		 	case 1:
	    	        			 path = Files.chooseFile(Files.getListOfFiles(path));
	    	        			 break;
	    	        		 	case 2:
	    	        		 		path = Files.createFile(path);
	    	        		 		break;
	    	        		 	case 3:
	    	        		 		 path = Files.moveHigher(path);
	    	        		 		 break;
	    	        		 	case 0:
	    	        			 break;
	    	        		 }
	    	        	 }
	    	        	 
	    	        	 
	    	             try {
	    	        	 Serialization.LongTermPersistenceWrite(clients,path);
	    	             } catch (FileNotFoundException e) {
	    	            	 System.out.println("Нет такого файла");
	    	            	 System.out.println("Нажмите любую клавишу для продолжения...");
		    	             new java.util.Scanner(System.in).nextLine();
		    	          
	    	             }
	    	        	 break;
	    	        	 
	    	         case 2:
	    	        	 
	    	        	 String find2 = "";
	    	        	 int k2= 0;
	    	        	 while(!"0".equals(find2)) {
	    	        		 System.out.println("Текущий путь: " + path);
	    	        		 Interface.printFileChooseMenu();
	    	        		 find2 = scan.next();
	    	        		 try {
			    	             k2 = Integer.parseInt(find2);
			    	         } catch (NumberFormatException e){
			    	             System.out.println("Неверный формат данных");
			    	         }
	    	        		 
	    	        		 switch(k2) {
	    	        		 	case 1:
	    	        			 path = Files.chooseFile(Files.getListOfFiles(path));
	    	        			 break;
	    	        		 	case 2:
	    	        		 		path = Files.createFile(path);
	    	        		 		break;
	    	        		 	case 3:
	    	        		 		
	    	        		 		 path = Files.moveHigher(path);
	    	        		 		 break;
	    	        		 	case 0:
	    	        			 break;
	    	        		 }
	    	        	 }
	    	        	 
	    	        	 try {
	    	        		 clients = Serialization.LongTermPersistenceRead(path);
		    	             } catch (FileNotFoundException e) {
		    	            	 System.out.println("Нет такого файла");
		    	            	 System.out.println("Нажмите любую клавишу для продолжения...");
			    	             new java.util.Scanner(System.in).nextLine();
		    	             }
	    	        	 
	    	        	 break;
	    	         }
	    	         
	         
	         }
	         Interface.cls();
	    }
	    scan.close();
	}
}
