 class Transaction {
    private String ammount;
    private String transId;
    private String date;
    private String type;
    private double amount;

    public Transaction(String ammount, String transID, String date) {
        this.ammount = ammount;
        this.transId = transID;
    }
    
    public Transaction(String ammount, String transID, String date, String type) {
        this.ammount = ammount;
        this.transId = transID;
        this.date = date;
        this.type = type;
    }
    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public String toString() {
        return "Transaction [ammount=" + ammount + ", transId=" + transId;
    }
    }