import java.util.ArrayList;

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
}
