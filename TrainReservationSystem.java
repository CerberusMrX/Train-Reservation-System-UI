import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

public class TrainReservationSystem extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;
    private DefaultTableModel bookingModel;
    private Map<String, Integer> trainPrices;
    private Map<String, Integer> availableSeats;
    private JTextField trainIdField, routeField, classField, seatsField, priceField;

    public TrainReservationSystem() {
        // Set Look-and-Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the frame
        setTitle("Train Reservation System");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize train data
        initializeTrainData();

        // Main panel with CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Create navigation bar
        JPanel navBar = new JPanel();
        navBar.setBackground(new Color(42, 87, 141)); // Professional dark blue background
        navBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        navBar.add(createCustomButton("Home", "home"));
        navBar.add(createCustomButton("Bookings", "bookings"));
        navBar.add(createCustomButton("Scenic Routes", "scenic"));
        navBar.add(createCustomButton("Profile", "profile"));
        navBar.add(createCustomButton("Train Details", "trainDetails"));
        navBar.add(createCustomButton("Update Train", "updateTrain"));
        navBar.add(createCustomButton("Search Train", "searchTrain"));
        navBar.add(createCustomButton("Routes", "routes"));
        navBar.add(createCustomButton("Booking Details", "bookingDetails"));

        add(navBar, BorderLayout.NORTH);

        // Create card panels
        cards.add(createHomePanel(), "home");
        cards.add(createBookingPanel(), "bookings");
        cards.add(createScenicRoutesPanel(), "scenic");
        cards.add(createProfilePanel(), "profile");
        cards.add(createTrainDetailsPanel(), "trainDetails");
        cards.add(createUpdateTrainPanel(), "updateTrain");
        cards.add(createSearchTrainPanel(), "searchTrain");
        cards.add(createRoutesPanel(), "routes");
        cards.add(createBookingDetailsPanel(), "bookingDetails");

        add(cards, BorderLayout.CENTER);
    }

    private void initializeTrainData() {
        trainPrices = new HashMap<>();
        availableSeats = new HashMap<>();

        addTrainData("Colombo to Kandy", 1500, 50);
        addTrainData("Colombo to Galle", 1200, 40);
        addTrainData("Colombo to Jaffna", 1800, 30);
        addTrainData("Colombo to Anuradhapura", 1600, 20);
        addTrainData("Colombo to Batticaloa", 1700, 25);
        addTrainData("Colombo to Nuwara Eliya", 2000, 15);
        addTrainData("Colombo to Matara", 1300, 45);
        addTrainData("Colombo to Trincomalee", 1400, 35);
        addTrainData("Colombo to Ratnapura", 1100, 50);
        addTrainData("Colombo to Polonnaruwa", 1400, 30);
        addTrainData("Colombo to Dambulla", 1550, 35);
        addTrainData("Colombo to Badulla", 1700, 25);
        addTrainData("Colombo to Matale", 1400, 40);
        addTrainData("Colombo to Chilaw", 1250, 50);
        addTrainData("Colombo to Ella", 1800, 20);
        addTrainData("Colombo to Arugam Bay", 1900, 15);
        addTrainData("Colombo to Puttalam", 1350, 30);
        addTrainData("Colombo to Vavuniya", 1650, 25);
        addTrainData("Colombo to Kegalle", 1200, 45);
    }

    private void addTrainData(String route, int price, int seats) {
        trainPrices.put(route, price);
        availableSeats.put(route, seats);
    }

    private JButton createCustomButton(String text, String cardName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(28, 72, 128));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, cardName);
            }
        });
        return button;
    }

    private JPanel createHomePanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/1.jpg").getImage()); // Replace with actual path
        panel.setLayout(new BorderLayout());
        panel.setOpaque(true);

        JLabel welcomeLabel = new JLabel("Welcome to the Train Reservation System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(Color.WHITE);
        welcomeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JLabel imageLabel = new JLabel(new ImageIcon("resources/images/home_image.jpg")); // Replace with actual path
        panel.add(imageLabel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createBookingPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/2.jpg").getImage()); // Replace with actual path
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Train ID:"), gbc);

        gbc.gridx = 1;
        JTextField trainIdField = new JTextField(20);
        panel.add(trainIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Passenger Name:"), gbc);

        gbc.gridx = 1;
        JTextField passengerNameField = new JTextField(20);
        panel.add(passengerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Seat Number:"), gbc);

        gbc.gridx = 1;
        JTextField seatNumberField = new JTextField(20);
        panel.add(seatNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Route:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> routeComboBox = new JComboBox<>(trainPrices.keySet().toArray(new String[0]));
        panel.add(routeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Class:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> classComboBox = new JComboBox<>(new String[]{"Economy", "Business", "First Class"});
        panel.add(classComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Number of Tickets:"), gbc);

        gbc.gridx = 1;
        JTextField ticketsField = new JTextField(10);
        panel.add(ticketsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton bookButton = new JButton("Book Ticket");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numTickets = Integer.parseInt(ticketsField.getText());
                    String route = (String) routeComboBox.getSelectedItem();
                    int price = trainPrices.get(route) * numTickets;
                    int available = availableSeats.get(route);

                    if (numTickets <= available) {
                        availableSeats.put(route, available - numTickets);
                        bookingModel.addRow(new Object[]{
                            trainIdField.getText(),
                            passengerNameField.getText(),
                            seatNumberField.getText(),
                            route,
                            classComboBox.getSelectedItem(),
                            numTickets,
                            price
                        });
                        JOptionPane.showMessageDialog(TrainReservationSystem.this,
                                "Booking successful! Total price: " + price);
                    } else {
                        JOptionPane.showMessageDialog(TrainReservationSystem.this,
                                "Not enough seats available!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TrainReservationSystem.this,
                            "Invalid number of tickets!");
                }
                cardLayout.show(cards, "bookingDetails");
            }
        });
        panel.add(bookButton, gbc);

        return panel;
    }

    private JPanel createScenicRoutesPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/scenic_routes_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Scenic Routes", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 5));
        for (int i = 1; i <= 5; i++) {
            imagePanel.add(new JLabel(new ImageIcon("resources/images/scenic" + i + ".jpg"))); // Replace with actual path
        }
        panel.add(imagePanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createProfilePanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/profile_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        JTextField phoneField = new JTextField(20);
        panel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        JTextArea addressArea = new JTextArea(4, 20);
        panel.add(new JScrollPane(addressArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton saveButton = new JButton("Save");
        panel.add(saveButton, gbc);

        return panel;
    }

    private JPanel createTrainDetailsPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/train_details_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Train Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Train ID", "Route", "Class", "Seats Available", "Price"};
        Object[][] data = {}; // Empty data for now
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createUpdateTrainPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/update_train_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Train ID:"), gbc);

        gbc.gridx = 1;
        trainIdField = new JTextField(20);
        panel.add(trainIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Route:"), gbc);

        gbc.gridx = 1;
        routeField = new JTextField(20);
        panel.add(routeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Class:"), gbc);

        gbc.gridx = 1;
        classField = new JTextField(20);
        panel.add(classField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Seats:"), gbc);

        gbc.gridx = 1;
        seatsField = new JTextField(20);
        panel.add(seatsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Price:"), gbc);

        gbc.gridx = 1;
        priceField = new JTextField(20);
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton updateButton = new JButton("Update Train");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainId = trainIdField.getText();
                String route = routeField.getText();
                int seats = Integer.parseInt(seatsField.getText());
                int price = Integer.parseInt(priceField.getText());

                trainPrices.put(route, price);
                availableSeats.put(route, seats);

                JOptionPane.showMessageDialog(TrainReservationSystem.this, "Train details updated!");
            }
        });
        panel.add(updateButton, gbc);

        return panel;
    }

    private JPanel createSearchTrainPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/search_train_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Search Train", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanel.add(new JLabel("Route:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> routeComboBox = new JComboBox<>(trainPrices.keySet().toArray(new String[0]));
        searchPanel.add(routeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        searchPanel.add(new JLabel("Class:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> classComboBox = new JComboBox<>(new String[]{"Economy", "Business", "First Class"});
        searchPanel.add(classComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String route = (String) routeComboBox.getSelectedItem();
                int price = trainPrices.getOrDefault(route, 0);
                int seats = availableSeats.getOrDefault(route, 0);

                JOptionPane.showMessageDialog(TrainReservationSystem.this,
                        "Route: " + route + "\nPrice: " + price + "\nAvailable Seats: " + seats);
            }
        });
        searchPanel.add(searchButton, gbc);

        panel.add(searchPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createRoutesPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/routes_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Available Routes", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Route", "Price", "Available Seats"};
        Object[][] data = new Object[trainPrices.size()][3];
        int i = 0;
        for (String route : trainPrices.keySet()) {
            data[i][0] = route;
            data[i][1] = trainPrices.get(route);
            data[i][2] = availableSeats.get(route);
            i++;
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createBookingDetailsPanel() {
        JPanel panel = new BackgroundPanel(new ImageIcon("resources/images/booking_details_bg.jpg").getImage()); // Replace with actual path
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Booking Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(titleLabel, BorderLayout.NORTH);

        bookingModel = new DefaultTableModel(new Object[]{"Train ID", "Passenger Name", "Seat Number", "Route", "Class", "Tickets", "Total Price"}, 0);
        JTable bookingTable = new JTable(bookingModel);
        JScrollPane scrollPane = new JScrollPane(bookingTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrainReservationSystem().setVisible(true);
            }
        });
    }

    // Inner class for custom background panel with image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image image) {
            this.backgroundImage = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

