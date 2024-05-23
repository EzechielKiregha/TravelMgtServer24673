package com.mirrorcompany.controller;

import javax.swing.*;
import java.awt.*;

public class TravelManagementApp extends JFrame {

    public TravelManagementApp() {
        setTitle("Travel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Dashboard Tab
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Welcome to the Travel Management System"));
        tabbedPane.addTab("Dashboard", dashboardPanel);

        // Travel Management Tab
        JPanel travelPanel = new JPanel(new GridLayout(2, 2));
        travelPanel.add(new JButton("View Itineraries"));
        travelPanel.add(new JButton("Create Itinerary"));
        travelPanel.add(new JButton("Expenses"));
        travelPanel.add(new JButton("Recommendations"));
        tabbedPane.addTab("Travel Management", travelPanel);

        // Flight Booking Tab
        JPanel flightPanel = new JPanel(new GridLayout(3, 1));
        flightPanel.add(new JButton("Book a Flight"));
        flightPanel.add(new JButton("View Bookings"));
        flightPanel.add(new JButton("Flight Status"));
        tabbedPane.addTab("Flight Booking", flightPanel);

        // Community Platform Tab
        JPanel communityPanel = new JPanel(new GridLayout(2, 2));
        communityPanel.add(new JButton("Groups"));
        communityPanel.add(new JButton("Chats"));
        communityPanel.add(new JButton("Comments"));
        communityPanel.add(new JButton("Updates"));
        tabbedPane.addTab("Community Platform", communityPanel);

        // User Profile Tab
        JPanel profilePanel = new JPanel(new GridLayout(2, 1));
        profilePanel.add(new JButton("View Profile"));
        profilePanel.add(new JButton("Edit Profile"));
        tabbedPane.addTab("User Profile", profilePanel);

        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TravelManagementApp());
    }
}

