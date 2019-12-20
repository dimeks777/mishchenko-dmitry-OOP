package ua.khpi.oop.mishchenko08;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class HotelRoom implements Externalizable {

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



		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(this.getNumberOfRoom());
			out.writeObject(this.getClassOfRoom());
			out.writeObject(this.getCountOfPlaces());
			
		}



		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			setNumberOfRoom(in.readInt());
			setClassOfRoom((String)in.readObject());
			setCountOfPlaces(in.readInt());
			
			
		}
		
		
	}

