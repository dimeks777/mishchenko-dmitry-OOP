package ua.khpi.oop.mishchenko08;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Interface {

	public static void printMenu() {
		System.out.println("Возможные варианты работы с данными:");
		System.out.println("1. Добавить нового клиента");
		System.out.println("2. Удалить клиента");
		System.out.println("3. Очистить список клиентов");
		System.out.println("4. Показать список");
		System.out.println("5. Демонстрация модели Long Term Persistence");
		System.out.println("6. Выход");

	}
	
	public static void cls() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	public static void printInputInterface() {
		System.out.println("1. Ввести номер паспорта");
		System.out.println("2. Ввести фамилию");
		System.out.println("3. Ввести имя");
		System.out.println("4. Ввести отчество");
		System.out.println("5. Ввести дату заселения");
		System.out.println("6. Ввести дату выселения");
		System.out.println("7. Ввести номер помещения");
		System.out.println("8. Ввести класс номера");
		System.out.println("9. Ввести количество мест в номере");
		System.out.println("10. Ввести причину заселения");
		System.out.println("11. Показать введённые данные ");
		System.out.println("12. Подтвердить ввод и добавить клиента");
		System.out.println("0. Выход");
		
	}
	
	public static void printXmlMenu() {
		System.out.println("1. Сохранить базу данных");
		System.out.println("2. Восстановить базу данных");
	}
	
	public static void printFileChooseMenu() {
		System.out.println("1. Продолжить выбор файла");
		System.out.println("2. Создать файл в текущей директории");
		System.out.println("3. На директорию выше");
		System.out.println("0. Выход");
	}
	
	public static  int inInt() {
		System.out.println("Ожидание ввода числа");
		@SuppressWarnings("resource")
		int user_int = new Scanner(System.in).nextInt();
		return user_int;
	}
	
	 public  static String inStr() {
		 System.out.println("Ожидание ввода строки");
			@SuppressWarnings("resource")
			String user_str = new Scanner(System.in).nextLine();
			return user_str;
		}
	 
	 public static GregorianCalendar inCalendar() {
		 System.out.println("Введите год");
		 int year = inInt();
		 System.out.println("Введите месяц");
		 int month = inInt();
		 System.out.println("Введите день");
		 int day = inInt();
		return new GregorianCalendar(year,month-1,day);
		 
		 
	 }

	
	public static void showData(int passportNumber,
			String surname,
			String name,
			String patronymic,
			GregorianCalendar settlementDate,
			GregorianCalendar evictionDate,
			int numberOfRoom,
			String classOfRoom,
			int countOfPlaces,
			ArrayList<String> settlementReason) {
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|  Номер паспорта  |       Фамилия       |        Имя        |        Отчество        |              Дата заселения              |              Дата выселения              |   Номер помещения   |       Класс       |   Количество мест   |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("|    %9d     |   %10s        |  %10s       |      %10s        |",passportNumber,surname,name,patronymic);
		System.out.print("       "+ settlementDate.getTime() + "       |       " + evictionDate.getTime() + "       |");
		System.out.printf("    %8d         |   %10s      |    %8d         |\n",numberOfRoom ,classOfRoom ,countOfPlaces);
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Причины заселения");
		int i = 1;
		for(String s: settlementReason) {
			System.out.println((i++) + ". " + s);
		}
		
			
	}
	public static Hotel create(int passportNumber,
			String surname,
			String name,
			String patronymic,
			GregorianCalendar settlementDate,
			GregorianCalendar evictionDate,
			int numberOfRoom,
			String classOfRoom,
			int countOfPlaces,
			ArrayList<String> settlementReason) {
		
				return new Hotel(passportNumber,surname,name,patronymic,settlementDate,evictionDate,new HotelRoom(numberOfRoom,classOfRoom,countOfPlaces),settlementReason);
		
	}
	
	public static void showArray(ArrayList<Hotel> input) {
		int i = 1;
		for(Hotel s: input) {
			System.out.println("///////////////////////////////" + (i++) + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|  Номер паспорта  |       Фамилия       |        Имя        |        Отчество        |              Дата заселения              |              Дата выселения              |   Номер помещения   |       Класс       |   Количество мест   |");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("|    %9d     |   %10s        |  %10s       |      %10s        |",s.getPassportNumber(),s.getSurname() ,s.getName() ,s.getPatronymic());
			System.out.print("       "+ s.getSettlementDate().getTime() + "       |       " + s.getEvictionDate().getTime() + "       |");
			System.out.printf("    %8d         |   %10s      |    %8d         |\n",s.hotelRoom.getNumberOfRoom() , s.hotelRoom.getClassOfRoom() , s.hotelRoom.getCountOfPlaces());
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Причины заселения");
			int y = 1;
			for(String s1: s.settlementReason) {
				System.out.println((y++) + ". " + s1);
			}
			System.out.println("\n\n\n");
			
		}
	}
}
