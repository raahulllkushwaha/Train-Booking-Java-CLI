import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class IRCTC {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        new IRCTC().start();
    }
    private LocalDate getDateInput(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true) {
            try {
                System.out.println(prompt + " (dd-MM-yyyy format): ");
                String dateStr = scanner.next();
                return LocalDate.parse(dateStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd-MM-yyyy format (e.g., 15-07-2025)");
            }
        }
    }
    public void start() {
        while (true) {
            System.out.println("Welcome to IRCTC APP");
            if (!userService.isLoggedIn()) {
                System.out.println("1. Register");
                System.out.println("2. LogIn");
                System.out.println("3. Exit");
                System.out.println("Enter your choice!");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid Choice.");
                }
            }
            else{
                showUserMenu();
            }
        }
    }


    public void register() {
        System.out.println("Enter username");
        String username = scanner.next();

        System.out.println("Enter password");
        String password = scanner.next();

        System.out.println("Enter your Full Name: ");
        scanner.nextLine();
        String fullName = scanner.nextLine();

        System.out.println("Enter age");
        String age = scanner.next();

        System.out.println("Enter Contact: ");
        String contact = scanner.next();

        userService.registerUser(username, password, fullName, contact, age);
    }

    public void login() {
        System.out.println("Enter username");
        String username = scanner.next();

        System.out.println("Enter password");
        String password = scanner.next();

        userService.loginUser(username, password);


    }

    private void showUserMenu() {
        while (userService.isLoggedIn()) {
            System.out.println("User Menu");
            System.out.println("1. Search Trains: ");
            System.out.println("2. Book Ticket: ");
            System.out.println("3. View my Tickets: ");
            System.out.println("4.Cancel Ticket: ");
            System.out.println("5. View all Trains: ");
            System.out.println("6. Logout");
            System.out.println("Enter your choice!");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> searchTrains();
                case 2 -> bookTicket();
                case 3 -> viewMyTicket();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listAllTrains();
                case 6 -> userService.logOutUser();
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    private void searchTrains() {
        System.out.println("Enter source station: ");
        String source = scanner.next();

        System.out.println("Enter destination station: ");
        String destination = scanner.next();

        LocalDate searchDate = getDateInput("Enter travel date");
        List<Train> trains = bookingService.searchTrainByDate(source, destination, searchDate);
        if (trains.isEmpty()) {
            System.out.println("No trains found between " + source + " and " + destination +
                    " on " + searchDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            return;
        }
        System.out.println("Trains found: ");
        for (Train train : trains) {
            System.out.println(train);
        }

        System.out.println("Do you want to book ticket ? (Yes/No): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println("Enter train ID to book the train");
            int trainID = scanner.nextInt();
            System.out.println("Enter number of seats to book: ");
            int seats = scanner.nextInt();

            Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainID, seats);
            if (ticket != null) {
                System.out.println("Booking Successful!");

                System.out.println(ticket);
            }
        } else {
            System.out.println("Returing to user menu......");
        }
    }

    private void bookTicket() {
        System.out.println("Enter source station: ");
        String source = scanner.next();

        System.out.println("Enter destination station: ");
        String destination = scanner.next();

        LocalDate searchDate = getDateInput("Enter travel date");

        List<Train> trains = bookingService.searchTrainByDate(source, destination, searchDate);
        if (trains.isEmpty()) {
            System.out.println("No trains available for the selected date");
            return;
        }
        System.out.println("Available Trains: ");
        for (Train train : trains) {
            System.out.println(train);
        }
        System.out.println("Enter train ID to book the train");
        int trainID = scanner.nextInt();
        System.out.println("Enter number of seats to book: ");
        int seats = scanner.nextInt();

        Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainID, seats);
        if (ticket != null) {
            System.out.println("Booking Successful!");

            System.out.println(ticket);
        }
    }


    private void viewMyTicket() {
        List<Ticket> ticketByUser = bookingService.getTicketByUser(userService.getCurrentUser());
        if(ticketByUser.isEmpty()){
            System.out.println("No Ticket Booked yet");
        }
        else {
            System.out.println("Your Tickets: ");
            for (Ticket ticket: ticketByUser){
                System.out.println(ticket);
            }
        }
    }
    private void cancelTicket(){
        System.out.println("Enter the Ticket ID to cancel the ticket: ");
        int ticketID = scanner.nextInt();
        bookingService.cancelTicket(ticketID,userService.getCurrentUser());
    }
    private void exitApp() {
        System.out.println("Thankyou for using my app.");
        System.exit(0);
    }
}

