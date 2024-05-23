import com.mirrorcompany.flightbooking.service.*;
import com.mirrorcompany.flightbooking.service.impl.*;
import com.mirrorcompany.service.*;
import com.mirrorcompany.service.impl.*;
import com.mirrorcompany.community.service.*;
import com.mirrorcompany.community.service.impl.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private static final int RMI_PORT = 1099;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(RMI_PORT);

            // Create instances of the remote service implementations
            UserService userService = new UserServiceImpl();
            ItineraryService itineraryService = new ItineraryServiceImpl();
            ExpenseService expenseService = new ExpenseServiceImpl();
            TripSegmentService tripSegmentService = new TripSegmentServiceImpl();
            RecommendationService recommendationService = new RecommendationServiceImpl();

            // Flight booking system services
            FlightService flightService = new FlightServiceImpl();
            BookingService bookingService = new BookingServiceImpl();
            PassengerService passengerService = new PassengerServiceImpl();
            PlaneService planeService = new PlaneServiceImpl();
            MaintenanceService maintenanceService = new MaintenanceServiceImpl();
            AirlineUserService airlineUserService = new AirlineUserServiceImpl();

            // Community platform services
            ChatService chatService = new ChatServiceImpl();
            CommentService commentService = new CommentServiceImpl();
            ItineraryChangeService itineraryChangeService = new ItineraryChangeServiceImpl();
            MessageService messageService = new MessageServiceImpl();
            NotificationService notificationService = new NotificationServiceImpl();
            UpdateService updateService = new UpdateServiceImpl();

            // Bind the remote objects to the RMI registry
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/UserService", userService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/ItineraryService", itineraryService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/ExpenseService", expenseService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/TripSegmentService", tripSegmentService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/RecommendationService", recommendationService);

            // Bind flight booking system services
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/FlightService", flightService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/BookingService", bookingService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/PassengerService", passengerService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/PlaneService", planeService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/MaintenanceService", maintenanceService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/AirlineUserService", airlineUserService);

            // Bind community platform services
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/ChatService", chatService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/CommentService", commentService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/ItineraryChangeService", itineraryChangeService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/MessageService", messageService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/NotificationService", notificationService);
            Naming.rebind("rmi://localhost:" + RMI_PORT + "/UpdateService", updateService);

            System.out.println("Travel Management Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
