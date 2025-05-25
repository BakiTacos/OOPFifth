public class BankLogin {
    private BankDLinkedList bankDList = new BankDLinkedList<>();

     public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public static boolean is12Length(String str) {
        if (str.length() >= 11 && str.length() <= 12) {
            return true;

        } else {
            return false;
    }
    }

    public void addUserAccount(String name, String password, String username, String phoneNumber, double balance) {
        bankDList.addUser(name, password, username, phoneNumber, balance);
    }

    public boolean validatePhoneNumbers(String name, String phoneNumber) {
        return bankDList.validatePhoneNumber(name, phoneNumber);
    }
    }