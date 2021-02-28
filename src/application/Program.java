package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Room number: ");
		int numberRoom = input.nextInt();
		input.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(input.nextLine());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(input.nextLine());
		
		Reservation reserva = new Reservation(numberRoom, checkIn, checkOut);
		System.out.print(reserva);
		
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = sdf.parse(input.nextLine());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(input.nextLine());
		
		reserva.updateDates(checkIn, checkOut);
		System.out.print(reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato da Data Invalido "+e.getMessage());
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva -  "+e.getMessage());
			
		}
		catch (Exception e) {
			System.out.println("Erro Inesperado");
		}

		
		input.close();

		
	}

}
