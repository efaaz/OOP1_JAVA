import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AdvancedBanking1 extends JFrame {
    static class Account {
        String platform;
        double balance;

        public Account(String platform, double balance) {
            this.platform = platform;
            this.balance = balance;
        }

        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public void deposit(double amount) {
            balance += amount;
        }
    }

    static class User {
        String username;
        String password;
        HashMap<String, Account> accounts = new HashMap<>();
        ArrayList<String> history = new ArrayList<>();

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            accounts.put("Bank", new Account("Bank", 1000));
            accounts.put("Bkash", new Account("Bkash", 500));
            accounts.put("Nogod", new Account("Nogod", 800));
        }

        public String getBalanceDisplay() {
            return String.format("Bank: $%.2f\nBkash: $%.2f\nNogod: $%.2f",
                    accounts.get("Bank").balance,
                    accounts.get("Bkash").balance,
                    accounts.get("Nogod").balance);
        }
    }

    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    JTextArea balanceArea = new JTextArea();
    JTextArea historyArea = new JTextArea();
    JComboBox<String> platformBox = new JComboBox<>(new String[]{"Bank", "Bkash", "Nogod"});
    JTextField amountField = new JTextField("100");
    JTextField infoField = new JTextField();

    JComboBox<String> fromBox = new JComboBox<>(new String[]{"Bank", "Bkash", "Nogod"});
    JComboBox<String> toBox = new JComboBox<>(new String[]{"Bank", "Bkash", "Nogod"});

    HashMap<String, User> users = new HashMap<>();
    User currentUser = null;

    public AdvancedBanking1() {
        setTitle("Online Banking System");
        setSize(600, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        mainPanel.setBackground(Color.PINK);

        initBankingPanel();

        currentUser = new User("defaultUser", "defaultPass");
        users.put("defaultUser", currentUser);

        loadHistoryFromFile();  // Load history on start
        updateUI();

        add(mainPanel);
        cardLayout.show(mainPanel, "banking");
        setVisible(true);
    }

    private void initBankingPanel() {
        JPanel bankPanel = new JPanel(null);
        bankPanel.setBackground(Color.PINK);

        JLabel welcome = new JLabel("Welcome to Banking");
        welcome.setBounds(20, 10, 300, 30);
        welcome.setFont(new Font("Arial", Font.BOLD, 16));
        bankPanel.add(welcome);

        JButton logout = new JButton("Exit");
        logout.setBounds(460, 10, 100, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(e -> System.exit(0));
        bankPanel.add(logout);

        balanceArea.setBounds(20, 50, 250, 60);
        balanceArea.setEditable(false);
        bankPanel.add(balanceArea);

        bankPanel.add(new JLabel("Amount:")).setBounds(20, 130, 60, 25);
        amountField.setBounds(80, 130, 100, 25);
        bankPanel.add(amountField);

        bankPanel.add(new JLabel("Platform:")).setBounds(200, 130, 60, 25);
        platformBox.setBounds(260, 130, 100, 25);
        bankPanel.add(platformBox);

        JButton depBtn = new JButton("Deposit");
        depBtn.setBounds(380, 130, 90, 25);
        depBtn.setBackground(Color.BLACK);
        depBtn.setForeground(Color.WHITE);

        JButton withBtn = new JButton("Withdraw");
        withBtn.setBounds(480, 130, 90, 25);
        withBtn.setBackground(Color.BLACK);
        withBtn.setForeground(Color.WHITE);

        depBtn.addActionListener(e -> {
            double amt = Double.parseDouble(amountField.getText());
            String plat = (String) platformBox.getSelectedItem();
            currentUser.accounts.get(plat).deposit(amt);
            currentUser.history.add("Deposited $" + amt + " to " + plat);
            updateUI();
        });

        withBtn.addActionListener(e -> {
            double amt = Double.parseDouble(amountField.getText());
            String plat = (String) platformBox.getSelectedItem();
            if (currentUser.accounts.get(plat).withdraw(amt)) {
                currentUser.history.add("Withdrew $" + amt + " from " + plat);
                updateUI();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
        });

        bankPanel.add(depBtn);
        bankPanel.add(withBtn);

        bankPanel.add(new JLabel("From:")).setBounds(20, 180, 50, 25);
        fromBox.setBounds(70, 180, 100, 25);
        bankPanel.add(fromBox);

        bankPanel.add(new JLabel("To:")).setBounds(180, 180, 30, 25);
        toBox.setBounds(210, 180, 100, 25);
        bankPanel.add(toBox);

        infoField.setBounds(320, 180, 180, 25);
        bankPanel.add(infoField);

        JButton transferBtn = new JButton("Transfer");
        transferBtn.setBounds(240, 220, 100, 25);
        transferBtn.setBackground(Color.BLACK);
        transferBtn.setForeground(Color.WHITE);

        transferBtn.addActionListener(e -> {
            String from = (String) fromBox.getSelectedItem();
            String to = (String) toBox.getSelectedItem();
            double amt = Double.parseDouble(amountField.getText());
            String info = infoField.getText().trim();

            if (from.equals("Bkash") && to.equals("Nogod")) {
                JOptionPane.showMessageDialog(this, "Bkash cannot transfer to Nogod.");
                return;
            }

            if (from.equals("Nogod") && to.equals("Bkash")) {
                JOptionPane.showMessageDialog(this, "Nogod cannot transfer to Bkash.");
                return;
            }

            if (from.equals(to)) {
                if (from.equals("Bkash") || from.equals("Nogod")) {
                    if (!info.matches("\\d{11}")) {
                        JOptionPane.showMessageDialog(this, "Enter a valid 11-digit number for " + to);
                        return;
                    }
                    String userNumber = "01700000000";
                    if (info.equals(userNumber)) {
                        JOptionPane.showMessageDialog(this, "Cannot transfer to the same " + to + " number.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot transfer to the same platform.");
                    return;
                }
            }

            if ((to.equals("Bkash") || to.equals("Nogod")) && !info.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "Enter a valid 11-digit phone number for " + to);
                return;
            }

            if (from.equals("Bank") && to.equals("Bank")) {
                String[] parts = info.split(":", 2);
                if (parts.length != 2 || parts[1].length() != 5 || !parts[1].matches("\\d{5}")) {
                    JOptionPane.showMessageDialog(this, "Enter valid format: BankName:12345");
                    return;
                }
            }

            if (currentUser.accounts.get(from).withdraw(amt)) {
                currentUser.accounts.get(to).deposit(amt);
                currentUser.history.add("Transferred $" + amt + " from " + from + " to " + to + " | Info: " + info);
                updateUI();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
        });

        bankPanel.add(transferBtn);

        JButton saveBtn = new JButton("Save History");
        saveBtn.setBounds(360, 220, 120, 25);
        saveBtn.setBackground(Color.BLACK);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.addActionListener(e -> saveHistoryToFile());
        bankPanel.add(saveBtn);

        historyArea.setBounds(20, 260, 540, 320);
        historyArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(historyArea);
        scroll.setBounds(20, 260, 540, 320);
        bankPanel.add(scroll);

        mainPanel.add(bankPanel, "banking");
    }

    private void updateUI() {
        if (currentUser != null) {
            balanceArea.setText(currentUser.getBalanceDisplay());
            StringBuilder sb = new StringBuilder("Transaction History:\n");
            for (String h : currentUser.history) sb.append(h).append("\n");
            historyArea.setText(sb.toString());
        }
    }

    private void saveHistoryToFile() {
        try (PrintWriter writer = new PrintWriter("history.txt")) {
            for (String h : currentUser.history) {
                writer.println(h);
            }
            JOptionPane.showMessageDialog(this, "History saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save history.");
        }
    }

    private void loadHistoryFromFile() {
        File file = new File("history.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    currentUser.history.add(line);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Failed to load history.");
            }
        }
    }

    public static void main(String[] args) {
        new AdvancedBanking1();
    }
}