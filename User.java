public class User {
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private double balance;
    private String accNum;

    public User(String name, String username, String password, String phoneNumber, double Balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accNum = calculateAccNumb();
        this.balance = Balance;
    }

    public String getName() {
        return name;
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

    private String calculateAccNumb() {
        accNum = "7020" + phoneNumber.substring(6,11);
        return accNum;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Account Number: " + accNum + username + password;
    }
}
