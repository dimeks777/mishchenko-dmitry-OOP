package ua.khpi.oop.mishchenko08;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Hotel implements Externalizable {

	private static final long serialVersionUID = 1L;
	
      
	private int passportNumber;
	private String surname;
	private String name;
	private String patronymic;
	private GregorianCalendar settlementDate;
	private GregorianCalendar evictionDate;
	HotelRoom hotelRoom;
	
    public ArrayList<String> settlementReason;
	

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
	
	public HotelRoom getHotelRoom() {
		return hotelRoom;
		
	}
	
	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom = hotelRoom;
		
	}
	
	public ArrayList<String> getsettlementReason(){
		return this.settlementReason;
		
	}
	
	public void setsettlementReason(ArrayList<String> settlementReason) {
		this.settlementReason = settlementReason;
	}
	
	

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getPassportNumber());
		out.writeObject(getSurname());
		out.writeObject(getName());
		out.writeObject(getPatronymic());
		out.writeObject(getSettlementDate());
		out.writeObject(getEvictionDate());
		
		out.writeObject(getHotelRoom());
		out.writeObject(this.getsettlementReason());
		
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		passportNumber = (in.readInt());
		surname = ((String)in.readObject());
		name = ((String)in.readObject());
		patronymic = ((String)in.readObject());
		settlementDate = ((GregorianCalendar)in.readObject());
		evictionDate = ((GregorianCalendar)in.readObject());
		
		hotelRoom = ((HotelRoom)in.readObject());
		settlementReason = ((ArrayList<String>) in.readObject());
		
		
	}

	
}
