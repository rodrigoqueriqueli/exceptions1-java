package application137;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { // propagando a exce��o
		// Aula 137 - Tratando exce��es (versionamento - solu��o RUIM)

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date(dd/MM/yyyy): ");
		Date checkIn = sf.parse(sc.next()); // Entrando data no formato de texto pelo sc.next, e o sf vai converter para
											// um date pra mim
		System.out.print("Check-out date(dd/MM/yyyy): ");
		Date checkOut = sf.parse(sc.next());

		if (!checkOut.after(checkIn)) { // se checkout n�o � depois do checkin, fa�a:
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date(dd/MM/yyyy): ");
			checkIn = sf.parse(sc.next()); // n�o est� declarando novas variaveis, est� reaproveitando as de cima
			System.out.print("Check-out date(dd/MM/yyyy): ");
			checkOut = sf.parse(sc.next()); // n�o est� declarando novas variaveis, est� reaproveitando as de cima

			Date now = new Date(); // criando data com hor�rio de agora
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates!");
			} else if (!checkOut.after(checkIn)) { // se a data de checkout n�o for posterior a data de checkin
				System.out.println("Error in reservation: Check-out date must be after check-in date!");

			} else {
				reservation.updateDates(checkIn, checkOut);// m�todo responsavel por atualizar as datas
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}

}
