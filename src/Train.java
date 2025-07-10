public class Train {
    private int trainId;
    private String name;
    private String source;
    private String destination;

    private int totalSeats;
    private int avilableSeats = 100;

    public Train(int trainId, String name, String source, String destination, int totalSeats) {
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.avilableSeats = totalSeats;
    }
}
