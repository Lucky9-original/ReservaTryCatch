package reservatrycatch;

import entities.exception.DomainException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Room number: ");
            int number = tec.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(tec.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(tec.next());
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation.toString());


            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(tec.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(tec.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation.toString());
        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (DomainException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error");
        }
        
        

    }

}
