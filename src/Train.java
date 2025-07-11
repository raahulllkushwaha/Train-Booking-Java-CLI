import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Train {
    private int trainId;
    private String name;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private int totalSeats;
    private int avilableSeats = 100;

    public Train(int trainId, String name, String source, String destination, int totalSeats,
                 LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime) {
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.avilableSeats = totalSeats;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvilableSeats() {
        return avilableSeats;
    }

    public void setAvilableSeats(int avilableSeats) {
        this.avilableSeats = avilableSeats;
    }

    public boolean bookSeats(int count){
        if(count <= avilableSeats){
            avilableSeats -= count;
            return true;
        }
        return false;
    }

    public void cancelSeats(int count){
        avilableSeats += count;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return trainId + " | " + name + " | " + source + " -> " + destination +
                " | Date: " + departureDate.format(dateFormatter) +
                " | Departure: " + departureTime.format(timeFormatter) +
                " | Arrival: " + arrivalTime.format(timeFormatter) +
                " | Seats Available: " + avilableSeats;
    }
}
