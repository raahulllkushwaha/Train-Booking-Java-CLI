import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainList = new ArrayList<>();

    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101, "Vande Bharat Express", "Delhi", "Mumbai", 100));
        trainList.add(new Train(102, "Narmada Express", "Pune", "Patna", 50));
        trainList.add(new Train(103, "Rajdhani Express", "Surat", "Indore", 80));trainList.add(new Train(101, "Vande Bharat Express", "Delhi", "Mumbai", 100));
        trainList.add(new Train(104, "Mumbai Hawrah Express", "Mumbai", "Hawrah", 90));
        trainList.add(new Train(105, "Shatabdi Express", "Agra", "Bhopal", 100));
        trainList.add(new Train(106, "Intercity Express", "Bhopal", "Indore", 60));
        trainList.add(new Train(107, "Janta Express", "Hyadrabad", "Lucknow", 70));
        trainList.add(new Train(108, "Tejas Express", "Delhi", "Bengaluru", 50));
        trainList.add(new Train(109, "xyz Express", "Nagpur", "Mumbai", 80));
        trainList.add(new Train(110, "abc Express", "Jabalpur", "Delhi", 90));
    }
    public List<Train> searchTrain(String source, String destination){
        List<Train> res = new ArrayList<>();
        for(Train train: trainList){
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)){
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
