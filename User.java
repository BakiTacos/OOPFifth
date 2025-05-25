public class User {
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private double balance;
    private String accNum;
    private StackLinkedList<Transaction> transactions;

    public User (String name, String username, String password, String phoneNumber, double Balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accNum = calculateAccNumb();
        this.balance = balance;
        this.transactions = new StackLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addTransaction (Transaction transaction) {
        transactions.push(transaction);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return password;    
    }

    public double getBalance() {
        return balance;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void showTransactions() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      TRANSACTION HISTORY     ║");
        System.out.println("╚══════════════════════════════╝");
        transactions.printStack();
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    private String calculateAccNumb() {
        accNum = "7020" + phoneNumber.substring(6,11);
        return accNum;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Account Number: " + accNum + username + password;
    }
    }