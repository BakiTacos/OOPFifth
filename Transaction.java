 class Transaction {
    private String ammount;
    private String transId;
    private String date;
    private String type;

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

    
}