class User {
    String username;
    String password;
    double balance;
    String accountNumber;
    String cardNumber;
    String cardType;
    String[] transactionHistory = new String[100];
    int jmlTransaction = 0;
        
    public User(String username, String password, String cardNumber, String cardType, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.accountNumber = generateAccountNumber();
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public User(String username, String password, String cardType) {
        this.username = username;
        this.password = password;
        this.balance = 0;  
        this.accountNumber = generateAccountNumber();
        this.cardNumber = generateCardNumber();
        this.cardType = cardType;
    }

    private String generateAccountNumber() {
        return "" + (int) (Math.random() * 100000) + 1000;
    }

    private String generateCardNumber() {
        return "" + (int) (Math.random() * 100000) + 1000;
    }

    private int generateCardExp() {
        return (int) (Math.random() * 365) + 100;
    }

    private int generateCVV() {
        return (int) (Math.random() * 365) + 100;
    }    

    public static void displayInfo(User user) {
        System.out.println("-----------------------------------------");
        System.out.println("|          Aurea Virtual Card           |");
        System.out.println("|                                       |");
        System.out.printf("| Username        : %-19s |%n", user.username);
        System.out.printf("| Account Number  : %-19s |%n", user.accountNumber);
        System.out.printf("| Card Number     : %-19s |%n", user.cardNumber);
        System.out.printf("| Card Type       : %-19s |%n", user.cardType);
        System.out.printf("| CVV Number      : %-19s |%n", user.generateCVV() + " *** ***");
        System.out.printf("| Card Expired in : %-19s |%n", user.generateCardExp() + " days");
        System.out.println("-----------------------------------------");
        }

    public String getUsername() {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance (double balance) {
        this.balance = balance;
    }

    public String getaccountNumber() {
        return accountNumber;
    }

    public void setaccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void tfHistory (String destinationUser, double amount) {
        if (jmlTransaction < transactionHistory.length) {
         transactionHistory[jmlTransaction] = "| Money sent Rp. " + amount + " to " + destinationUser;
         jmlTransaction++;
        }
     }
 
    public void addSuggestion(SuggestionQueue queue, String suggestion) { 
         queue.Enqueue(this.username, suggestion);
     }
 
     public void viewHistory() {
        if (jmlTransaction == 0) {
             System.out.println("Transaction not detected.");
             
         } else {
             System.out.println();
             System.out.println("-- Transfer History --");
             for (int i = 0; i < jmlTransaction; i++) {
             System.out.println(transactionHistory[i]);
             }
         }
     }
}
