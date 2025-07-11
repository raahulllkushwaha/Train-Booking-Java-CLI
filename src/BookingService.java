import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
public class BookingService {
    private List<Train> trainList = new ArrayList<>();

    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101, "Vande Bharat Express", "Delhi", "Mumbai", 100,
                LocalDate.of(2025, 7, 15), LocalTime.of(6, 0), LocalTime.of(18, 30)));
        trainList.add(new Train(102, "Narmada Express", "Pune", "Patna", 50,
                LocalDate.of(2025, 7, 16), LocalTime.of(8, 30), LocalTime.of(20, 15)));
        trainList.add(new Train(103, "Rajdhani Express", "Surat", "Indore", 80,
                LocalDate.of(2025, 7, 17), LocalTime.of(14, 0), LocalTime.of(18, 45)));
        trainList.add(new Train(104, "Mumbai Howrah Express", "Mumbai", "Howrah", 90,
                LocalDate.of(2025, 7, 18), LocalTime.of(22, 30), LocalTime.of(16, 20)));
        trainList.add(new Train(105, "Shatabdi Express", "Agra", "Bhopal", 100,
                LocalDate.of(2025, 7, 19), LocalTime.of(5, 45), LocalTime.of(12, 30)));
        trainList.add(new Train(106, "Intercity Express", "Bhopal", "Indore", 60,
                LocalDate.of(2025, 7, 20), LocalTime.of(9, 15), LocalTime.of(13, 0)));
        trainList.add(new Train(107, "Janta Express", "Hyderabad", "Lucknow", 70,
                LocalDate.of(2025, 7, 21), LocalTime.of(11, 30), LocalTime.of(6, 45)));
        trainList.add(new Train(108, "Tejas Express", "Delhi", "Bengaluru", 50,
                LocalDate.of(2025, 7, 22), LocalTime.of(16, 0), LocalTime.of(8, 30)));
        trainList.add(new Train(109, "xyz Express", "Nagpur", "Mumbai", 80,
                LocalDate.of(2025, 7, 23), LocalTime.of(13, 45), LocalTime.of(19, 30)));
        trainList.add(new Train(110, "abc Express", "Jabalpur", "Delhi", 90,
                LocalDate.of(2025, 7, 24), LocalTime.of(7, 20), LocalTime.of(15, 50)));
    }
    public List<Train> searchTrainByDate(String source, String destination, LocalDate date){
        List<Train> res = new ArrayList<>();
        for(Train train: trainList){
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination) && train.getDepartureDate().equals(date)){
                res.add(train);
            }
        }
        return res;
    }

    public Ticket bookTicket(User user, int trainId, int seatCount){
        for (Train train: trainList){
            if(train.getTrainId() == trainId){
                if(train.bookSeats(seatCount)){
                    Ticket ticket = new Ticket(user, train, seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else{
                    System.out.println("No enough seats available");
                    return null;
                }
            }
        }
        System.out.println("Train id not found");
        return null;
    }

    public List<Ticket> getTicketByUser(User user) {
       List<Ticket> res = new ArrayList<>();
       for (Ticket ticket: ticketList){
           if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
               res.add(ticket);
           }
       }
       return res;
    }

    public boolean cancelTicket(int ticketId, User user){
        Iterator<Ticket> iterator = ticketList.listIterator();
        while ((iterator.hasNext())){
            Ticket ticket = iterator.next();
            if(ticket.getTicketId() == ticketId && ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                Train train = ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket " + ticketId + "Cancelled successfully");
                return true;
            }
        }
        System.out.println("Ticket not found or does not belong to current user");
        return false;
    }


    public void listAllTrains(){
        System.out.println("List of all trains: ");
        for(Train train: trainList){
            System.out.println(train);
        }
    }
}
