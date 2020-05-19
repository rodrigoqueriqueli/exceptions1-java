package application137;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// Aula 137 - Tratando exce��es (versionamento - solu��o BOA)

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date(dd/MM/yyyy): ");
			Date checkIn = sf.parse(sc.next()); // Entrando data no formato de texto pelo sc.next, e o sf vai converter
												// para um date pra mim
			System.out.print("Check-out date(dd/MM/yyyy): ");
			Date checkOut = sf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date(dd/MM/yyyy): ");
			checkIn = sf.parse(sc.next()); // n�o est� declarando novas variaveis, est� reaproveitando as de cima
			System.out.print("Check-out date(dd/MM/yyyy): ");
			checkOut = sf.parse(sc.next()); // n�o est� declarando novas variaveis, est� reaproveitando as de cima

			reservation.updateDates(checkIn, checkOut);// m�todo responsavel por atualizar as datas
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date Format");
		} catch (DomainException e) { // e � o apelido da exec��o
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
