import java.util.InputMismatchException;
import java.util.Scanner;

public class VirtualWallet {
    static Scanner scan = new Scanner(System.in); // Untuk menjadikan scanner universal
    static StackLinkedList<User> userStack = new StackLinkedList<>();
    static UserMenu userMenu = new UserMenu();
    static BankLogin bankSystem = new BankLogin();
    static BankDLinkedList<User> bankUser = new BankDLinkedList<>();

    public static void main(String[] args) {
        //List storage

        //Dummy Test   

        bankUser.addUser("Array Pannadana", "pass123", "Array", "081288883333", 1000);
        bankUser.addUser("Nikki Tirta Iwan", "pass456", "Nikki", "081299992222", 2000);
        bankSystem.addUserAccount("Array Pannadana", "pass123", "Array", "081288883333", 1000);
        bankSystem.addUserAccount("Nikki Tirta Iwan", "pass456", "Nikki", "081299992222", 2000);

        boolean login = false;
        // Login Interface
        do {
        try {
        System.out.println("\n── Welcome to Aurea Virtual Wallet ──");
        System.out.println("| 1. Register                         |");
        System.out.println("| 2. Login                            |");
        System.out.println("| 3. Exit                             |");
        System.out.println("───────────────────────────────────────");
        System.out.print("Choose your options: ");
        int choices = Integer.parseInt(scan.nextLine());

        switch (choices) {
            case 1:
            System.out.print("Enter your Phone number: ");
            String phoneNumber = scan.nextLine();
            if (bankSystem.isNumeric(phoneNumber) == true && bankSystem.is12Length(phoneNumber) == true) {
            System.out.print("Enter your Full Name: ");
            String name = scan.nextLine();
             System.out.print("Enter your Username: ");
            String username = scan.nextLine();
            System.out.print("Enter your Password: ");
            String password = scan.nextLine();
            
            if (bankUser.validatePhoneNumber(name, phoneNumber) == true) {
            bankUser.addUser(name, password, username, phoneNumber, 0);
            }
            } else {
                System.out.println("Phone number must be numeric or 12 number");
            }
            break;
            
            case 2:
                System.out.print("Enter your Username: ");
                String loginUsername = scan.nextLine();
                System.out.print("Enter your Password: ");
                String loginPassword = scan.nextLine();
                // Panggil loginUser dari StackLinkedList
                User validateUser = bankUser.loginUser(loginUsername, loginPassword);
                if (validateUser != null) {
                    System.out.println("Login successful! Welcome, " + validateUser.getName());
                    userMenu.userMenu();
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
                break;

                case 3:
                System.out.println("Thank you for using Aurea Virtual Wallet...");
                System.exit(0);
                scan.close();
                break;

                case 4:
                bankUser.displayTest();
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
                catch(InputMismatchException e) {
            System.out.println("Please input wth the correct procedure!");
            }
            catch(NumberFormatException e) {
            System.out.println("Please input wth the correct procedure!"); 
            }
            } while (!login);
        } 
}
