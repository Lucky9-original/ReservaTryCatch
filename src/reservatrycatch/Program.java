package reservatrycatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = tec.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(tec.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(tec.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation.toString());

            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(tec.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(tec.next());

            String error = reservation.updateDates(checkIn, checkOut);
            
            if (error != null){
                System.out.println(error);
            } else {
                System.out.println(reservation.toString());
            }

        }

    }

}
