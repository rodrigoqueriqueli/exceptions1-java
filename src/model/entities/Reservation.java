package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sf = new SimpleDateFormat(
			"dd/MM/yyyy"); /*
							 * o static permite que o SimpleDateFormat seja instanciado uma única vez,
							 * independente do número de obejtos reservation eu tiver
							 */

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

	public long duration() { // long = inteiro mais longo
		long diff = checkOut.getTime() - checkIn.getTime(); // estou pegando a diferença entre datas em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // convertendo valor diff que está em milisegundos
																	// para dias
	}

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date(); // criando data com horário de agora
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates!";
		}
		if (!checkOut.after(checkIn)) { // se a data de checkout não for posterior a data de checkin
			return "Check-out date must be after check-in date!";
		}
		this.checkIn = checkIn; // CheckIn do meu objeto receber o checkIn que veio como argumento do método
		this.checkOut = checkOut; // CheckOut do meu objeto receber o checkOut que veio como argumento do método
		return null; //se retornar nulo é pq a operação não deu nenhum erro
	}

	@Override // o to String é uma sobreposição
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sf.format(checkIn) + ", check-out: " + sf.format(checkOut) + ", "
				+ duration() + " nights";
	}
}
