public class User {
    private String name;
    private String username;
    private String password;
    private double balance;
    private String accNum;

    public User(String name, String username, String password, double Balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accNum = generateAccountNumber();
        this.balance = Balance;
    }

    public String getName() {
        return name;
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

    private String generateAccountNumber() {
        return " " + (int) (Math.random() * 100000) + 1000;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Account Number: " + accNum + username + password;
    }
}
