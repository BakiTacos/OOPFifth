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
        do  {
        try {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║        WELCOME TO AUREA VIRTUAL WALLET       ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1. Register                                 ║");
        System.out.println("║  2. Login                                    ║");
        System.out.println("║  3. Exit                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Choose your options: ");
        int choices = Integer.parseInt(scan.nextLine());

        switch (choices) {
            case 1:
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║           REGISTER             ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.print ("║ Phone Number (12 digits) : ");
            String phoneNumber = scan.nextLine();

            if (bankSystem.isNumeric(phoneNumber) && bankSystem.is12Length(phoneNumber)) {
                System.out.print ("║ Full Name               : ║");
                String name = scan.nextLine();
                System.out.print ("║ Username                : ║");
                String username = scan.nextLine();
                System.out.print ("║ Password                : ║");
                String password = scan.nextLine();
                System.out.println("╚════════════════════════════════╝");

                if (bankSystem.validatePhoneNumbers(name, phoneNumber)) {
                    bankUser.addUser(name, password, username, phoneNumber, 0);
                    System.out.println("\nRegistration successful! You can now login.");
                } else {
                    System.out.println("\nPhone number is already registered with another user.");
                }
            } else {
                System.out.println("╚════════════════════════════════╝");
                System.out.println("\nPhone number must be numeric and exactly 12 digits.");
            }
            break;
            
            case 2:
                System.out.println();
                System.out.println("╔════════════════════════════╗");
                System.out.println("║           LOGIN            ║");
                System.out.println("╚════════════════════════════╝");

                System.out.print("Enter Username: ");
                String loginUsername = scan.nextLine();

                System.out.print("Enter Password: ");
                String loginPassword = scan.nextLine();

                // Setelah input selesai, tampilkan dengan format rapi
                System.out.println();
                System.out.println("╔════════════════════════════╗");
                System.out.println("║           LOGIN            ║");
                System.out.println("╠════════════════════════════╣");
                System.out.printf("║ Username : %-16s║\n", loginUsername);
                System.out.printf("║ Password : %-16s║\n", "********");
                System.out.println("╚════════════════════════════╝");



                // Panggil loginUser dari StackLinkedList
                User validateUser = bankUser.loginUser(loginUsername, loginPassword);
                if (validateUser != null) {
                    System.out.println("\nLogin successful! Welcome, " + validateUser.getName() + ".");
                    Menu.currentUser = validateUser;
                    userMenu.userMenu();
                } else {
                    System.out.println("\nLogin failed. Invalid username or password.");
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