package ua.khpi.oop.mishchenko07;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


class HotelRoom implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int numberOfRoom;
	private String classOfRoom;
	private int countOfPlaces;
	
	
	HotelRoom(){
		setNumberOfRoom(0);
		setClassOfRoom("NULL");
		setCountOfPlaces(0);
	}
	
	
	
	public HotelRoom(HotelRoom hotelRoom) {
		this.numberOfRoom = hotelRoom.numberOfRoom;
		this.classOfRoom = hotelRoom.classOfRoom;
		this.countOfPlaces = hotelRoom.countOfPlaces;
	}
	
	
	public HotelRoom(int numberOfRoom,String classOfRoom, int countOfPlaces ) {
		this.numberOfRoom = numberOfRoom;
		this.classOfRoom = classOfRoom;
		this.countOfPlaces = countOfPlaces;
	}


	public int getNumberOfRoom() {
		return numberOfRoom;
	}

	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	public String getClassOfRoom() {
		return classOfRoom;
	}

	public void setClassOfRoom(String classOfRoom) {
		this.classOfRoom = classOfRoom;
	}

	public int getCountOfPlaces() {
		return countOfPlaces;
	}

	public void setCountOfPlaces(int countOfPlaces) {
		this.countOfPlaces = countOfPlaces;
	}
	
	
}
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	
      
	private int passportNumber;
	private String surname;
	private String name;
	private String patronymic;
	private GregorianCalendar settlementDate;
	private GregorianCalendar evictionDate;
	HotelRoom hotelRoom;
	
    ArrayList<String> settlementReason;
	
	public Hotel() {
		setPassportNumber(0);
		setSurname("NULL");
		setName("NULL");
		setPatronymic("NULL");
		setSettlementDate(new GregorianCalendar(2000, Calendar.JANUARY , 1));
		setEvictionDate(new GregorianCalendar(2000, Calendar.JANUARY , 1));
		hotelRoom = new HotelRoom();
		settlementReason = new ArrayList<String>();
	}
	
	public Hotel(int passportNumber,String surname, String name,String patronymic,GregorianCalendar settlementDate,GregorianCalendar evictionDate,HotelRoom hotelRoom,ArrayList<String> settlementReason) {
		setPassportNumber(passportNumber);
		setSurname(surname);
		setName(name);
		setPatronymic(patronymic);
		setSettlementDate(settlementDate);
		setEvictionDate(evictionDate);
		this.hotelRoom = hotelRoom;
		this.settlementReason = settlementReason;
	}
	
	public Hotel(Hotel input) {
		setPassportNumber(input.passportNumber);
		setSurname(input.surname);
		setName(input.name);
		setPatronymic(input.patronymic);
		setSettlementDate(input.settlementDate);
		setEvictionDate(input.evictionDate);
		hotelRoom = input.hotelRoom;
		settlementReason = input.settlementReason;
	}
	
	public int getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	public GregorianCalendar getSettlementDate() {
		return settlementDate;
	}


	public void setSettlementDate(GregorianCalendar settlementDate) {
		this.settlementDate = settlementDate;
	}


	public GregorianCalendar getEvictionDate() {
		return evictionDate;
	}


	public void setEvictionDate(GregorianCalendar evictionDate) {
		this.evictionDate = evictionDate;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}



	
}
