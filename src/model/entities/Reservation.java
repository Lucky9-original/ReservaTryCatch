package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

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

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }
    
    public long duration(){
        long diff = this.checkOut.getTime() - this.checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public String updateDates(Date checkIn, Date checkOut){
        Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                return "Error in reservation: Reservation dates for update must be future dates";
            } 
            if (!checkOut.after(checkIn)) {
                return "Error in reservation: check-out date must be after check-in date";
            }
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: Room ")
                .append(this.roomNumber)
                .append(", check-in: ")
                .append(sdf.format(checkIn))
                .append(", check-out: ")
                .append(sdf.format(checkOut))
                .append(", ")
                .append(this.duration())
                .append(" nights\n");
        return sb.toString();
    }
    
    
    
}
