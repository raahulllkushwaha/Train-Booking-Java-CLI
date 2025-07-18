# Train Booking System

A simple console-based train booking application built in Java that simulates the functionality of IRCTC (Indian Railway Catering and Tourism Corporation). This application allows users to register, login, search for trains, book tickets, and manage their bookings.

## Features

### User Management
- **User Registration**: Create new user accounts with username, password, full name, and contact information
- **User Login/Logout**: Secure authentication system
- **Session Management**: Maintains user sessions during application usage

### Train Management
- **Pre-loaded Train Data**: Comes with 10 sample trains covering various routes across India
- **Train Search**: Search trains by source and destination stations
- **View All Trains**: Display complete list of available trains with seat availability

### Booking System
- **Ticket Booking**: Book tickets for available trains with specified number of seats
- **Seat Management**: Real-time seat availability tracking
- **Booking Confirmation**: Generate unique ticket IDs for each booking
- **View Bookings**: Users can view all their booked tickets

### Cancellation
- **Ticket Cancellation**: Cancel existing bookings
- **Seat Release**: Automatically release seats back to available pool upon cancellation
- **User Validation**: Ensure only ticket owners can cancel their bookings

## System Architecture

The application follows Object-Oriented Programming principles with the following main components:

```
├── src/
│   ├── IRCTC.java          # Main application class with user interface
│   ├── User.java           # User entity class
│   ├── Train.java          # Train entity class  
│   ├── Ticket.java         # Ticket entity class
│   ├── UserService.java    # User management service
│   └── BookingService.java # Train and booking management service
```

### Class Descriptions

- **IRCTC**: Main application class that handles user interface and menu navigation
- **User**: Represents user entities with username, password, full name, and contact
- **Train**: Represents train entities with ID, name, source, destination, and seat management
- **Ticket**: Represents booking tickets with unique IDs and user/train associations
- **UserService**: Manages user registration, authentication, and session handling
- **BookingService**: Handles train searches, ticket booking, and cancellations

## Sample Train Data

The application comes pre-loaded with the following trains:

| Train ID | Train Name | Source | Destination | Total Seats |
|----------|------------|---------|-------------|-------------|
| 101 | Vande Bharat Express | Delhi | Mumbai | 100 |
| 102 | Narmada Express | Pune | Patna | 50 |
| 103 | Rajdhani Express | Surat | Indore | 80 |
| 104 | Mumbai Howrah Express | Mumbai | Howrah | 90 |
| 105 | Shatabdi Express | Agra | Bhopal | 100 |
| 106 | Intercity Express | Bhopal | Indore | 60 |
| 107 | Janta Express | Hyderabad | Lucknow | 70 |
| 108 | Tejas Express | Delhi | Bengaluru | 50 |
| 109 | XYZ Express | Nagpur | Mumbai | 80 |
| 110 | ABC Express | Jabalpur | Delhi | 90 |

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 19 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation

1. Clone the repository:
```bash
git clone https://github.com/raahulllkushwaha/Train-Booking-Java-CLI.git
cd  Train-Booking-Java-CLI
```

2. Compile the Java files:
```bash
javac src/*.java
```

3. Run the application:
```bash
java -cp src IRCTC
```

### Usage

1. **First Time Users**:
    - Select option 1 to register
    - Provide username, password, full name, and contact details
    - Login with your credentials

2. **Existing Users**:
    - Select option 2 to login
    - Enter your username and password

3. **Available Operations**:
    - Search trains between stations
    - Book tickets for available trains
    - View your booked tickets
    - Cancel existing bookings
    - View all available trains
    - Logout when done

## Key Features Implementation

### Seat Management
- Real-time seat availability tracking
- Automatic seat booking and release
- Validation for sufficient seats before booking

### User Authentication
- Username uniqueness validation
- Password verification
- Session management for logged-in users

### Data Persistence
- In-memory storage using Java collections
- User data stored in HashMap
- Train and ticket data stored in ArrayLists

## Current Limitations

- **No Database Integration**: All data is stored in memory and lost when application terminates
- **No Data Validation**: Limited input validation for user entries
- **Console-Based UI**: Simple text-based interface
- **No Payment Integration**: Booking confirmation without payment processing

## Future Enhancements

### 🚀 Coming Soon
- **Database Integration**: PostgreSQL/MySQL database for persistent data storage
- **User Data Persistence**: Save user accounts and booking history
- **Enhanced Validation**: Input validation and error handling
- **Payment Gateway**: Integration with payment processing
- **Web Interface**: Modern web-based user interface
- **REST API**: API endpoints for mobile app integration

### 📝 Contributing

We welcome contributions! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/your-feature-name`
3. **Make your changes** and test thoroughly
4. **Commit your changes**: `git commit -m 'Add some feature'`
5. **Push to the branch**: `git push origin feature/your-feature-name`
6. **Submit a Pull Request**

### Areas for Contribution
- Database integration (JPA/Hibernate)
- Input validation and error handling
- Unit testing implementation
- Web interface development
- API development
- Documentation improvements
- Bug fixes and performance optimizations

## Technology Stack

- **Language**: Java 19
- **Collections**: ArrayList, HashMap, Iterator
- **Architecture**: Object-Oriented Programming
- **Interface**: Console-based
- **IDE**: IntelliJ IDEA (project files included)

## Project Structure

```
Train-Booking-System/
├── .idea/                    # IntelliJ IDEA project files
│   ├── .gitignore
│   ├── misc.xml
│   ├── modules.xml
│   └── vcs.xml
├── src/                      # Source code
│   ├── IRCTC.java
│   ├── User.java
│   ├── Train.java
│   ├── Ticket.java
│   ├── UserService.java
│   └── BookingService.java
├── Train Booking.iml         # IntelliJ module file
└── README.md                 # This file
```

## License

This project is open source and available under the [MIT License](LICENSE).

## Contact

For questions, suggestions, or contributions, please feel free to:
- Open an issue on GitHub
- Submit a pull request
- Contact the maintainers

---

**Note**: This is a learning project designed to demonstrate core Java concepts including OOP, collections, and basic application architecture. The database integration and enhanced features will be added in future updates.
##       ~ Developed by Rahul Kushwaha
## Happy Coding! 🚂