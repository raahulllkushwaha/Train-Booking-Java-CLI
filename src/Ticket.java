import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Ticket {

    private int ticketId;
    private User user;
    private Train train;
    private int seatBooked;

    private static int counter = 1001;
    public Ticket(User user, Train train, int seatBooked) {
        this.ticketId = counter++;
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }



    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return "Ticket ID: " + ticketId +
                " | Train: " + train.getName() +
                " | Route: " + train.getSource() + " -> " + train.getDestination() +
                " | Date: " + train.getDepartureDate().format(dateFormatter) +
                " | Departure: " + train.getDepartureTime().format(timeFormatter) +
                " | Arrival: " + train.getArrivalTime().format(timeFormatter) +
                " | Seats: " + seatBooked +
                " | Booked By: " + user.getFullName();
    }
}
