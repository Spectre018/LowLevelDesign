import java.util.List;

public class Booking {
    int bookingId;
    List<Seat> bookedSeat;
    Payment payment;
    Show show;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public List<Seat> getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(List<Seat> bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
