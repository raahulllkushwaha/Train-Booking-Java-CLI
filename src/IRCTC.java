import java.util.Scanner;

public class IRCTC {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        new IRCTC().start();
    }

    public void start(){
        while (true){
            System.out.println("Welcome to IRCTC APP");
            if(!userService.isLoggedIn()){
                System.out.println("1. Register");
                System.out.println("2. LogIn");
                System.out.println("3. Exit");
                System.out.println("Enter your choice!");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid Choice.");
                }
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

        System.out.println("Enter Contact: ");
        String contact = scanner.next();

        userService.register(username, password, fullName, contact);
    }

    public void login(){
        System.out.println("Enter username");
        String username = scanner.next();

        System.out.println("Enter password");
        String password = scanner.next();

        userService.loginUser(username,password);


    }

    private void showUserMenu(){

    }
}

