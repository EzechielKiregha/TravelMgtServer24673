package com.mirrorcompany.controller;

import com.mirrorcompany.flightbooking.service.*;
import com.mirrorcompany.flightbooking.service.impl.*;
import com.mirrorcompany.service.*;
import com.mirrorcompany.service.impl.*;
import com.mirrorcompany.community.service.*;
import com.mirrorcompany.community.service.impl.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ControlServer {
    private static final int RMI_PORT = 1099;

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
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
            registry.rebind("UserService", userService);
            registry.rebind("ItineraryService", itineraryService);
            registry.rebind("ExpenseService", expenseService);
            registry.rebind("TripSegmentService", tripSegmentService);
            registry.rebind("RecommendationService", recommendationService);

            // Bind flight booking system services
            registry.rebind("FlightService", flightService);
            registry.rebind("BookingService", bookingService);
            registry.rebind("PassengerService", passengerService);
            registry.rebind("PlaneService", planeService);
            registry.rebind("MaintenanceService", maintenanceService);
            registry.rebind("AirlineUserService", airlineUserService);

            // Bind community platform services
            registry.rebind("ChatService", chatService);
            registry.rebind("CommentService", commentService);
            registry.rebind("ItineraryChangeService", itineraryChangeService);
            registry.rebind("MessageService", messageService);
            registry.rebind("NotificationService", notificationService);
            registry.rebind("UpdateService", updateService);

            System.out.println("Travel Management Server is running on port : ["+RMI_PORT+"]");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

