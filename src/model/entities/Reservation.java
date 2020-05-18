package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy"); /*o static permite que o 
	SimpleDateFormat seja instanciado uma �nica vez, independente do n�mero de obejtos reservation eu tiver*/
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() { //long = inteiro mais longo
		long diff = checkOut.getTime() - checkIn.getTime(); //estou pegando a diferen�a entre datas em milisegundos 	
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	//convertendo valor diff que est� em milisegundos para dias
	}

	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn; //CheckIn do meu objeto receber o checkIn que veio como argumento do m�todo
		this.checkOut = checkOut; //CheckOut do meu objeto receber o checkOut que veio como argumento do m�todo
	}
	
	@Override //o to String � uma sobreposi��o
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sf.format(checkIn)
				+ ", check-out: "
				+ sf.format(checkOut)
				+ ", "
				+ duration()
				+" nights";
	}
}
