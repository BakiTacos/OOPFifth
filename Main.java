import java.util.Scanner;

public class Main {
    static Scanner Scn = new Scanner(System.in);
    WalletSystem userAccounts = new WalletSystem();
    static User[] users = new User[100];
    static int indexUser = -1;
    static SuggestionQueue suggestionQueue = new SuggestionQueue(100);

    public static void main(String[] args) {

        

        users[0] = new User("Gallant", "666", "748249", "VISA", 5000);
        users[1] = new User("Arya", "69", "087775933022", "GPN", 10000);
        users[2] = new User("Marvin", "6969", "752831", "VISA", 0);
        users[3] = new User("Femi", "9696", "138257", "GPN", 0);
        Admin admin = new Admin("admin", "6969");
        admin.suggestionQueue(suggestionQueue);

        while (true) {
            System.out.println();
            System.out.println("-- Welcome to Aurea Virtual Bank --");
            System.out.println("| Register [1]");
            System.out.println("| Login    [2]");
            System.out.println("| Exit     [3]");
            System.out.print("Pick one of these options: ");
            int choice = Scn.nextInt();
            Scn.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.exit(0);
                    break;

                case 69:
                    admin.adminLogin(users, admin);
                    break;
                    
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    public static void register() {
        System.out.println();
        System.out.println("-- Register Menu --");
        System.out.print("Enter username: ");
        String username = Scn.nextLine();
        System.out.print("Enter password: ");
        String password = Scn.nextLine();
        System.out.print("Choose card type ( VISA or GPN ): ");
        String cardType = Scn.nextLine();
        
        if (username == "" || password == "") {
            System.out.println("Username or password cannot be blank. Try again");
            return;
        }

        if (!cardType.equals("VISA") && !cardType.equals ("GPN")) {
            System.out.println("Invalid card type! Please choose VISA or GPN.");
            System.out.print("Choose card type (VISA or GPN): ");
            cardType = Scn.nextLine();
        }
    
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = new User(username, password, cardType);
                System.out.println();
                return;
            }
        }
    }

    public static int seqSearchUser(User[] users, String username) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getUsername().equals(username)) {
                return i;
                }
            }
        return -1;
    }
    
    public static void login() {
        System.out.println();
        System.out.println("-- Login Menu --");
        System.out.print("Enter username : ");
        String username = Scn.nextLine();

        System.out.print("Enter password : ");
        String password = Scn.nextLine();

        int userIndex = seqSearchUser(users, username);
        if (userIndex != -1 && users[userIndex].getPassword().equals(password)) {
        indexUser = userIndex;
        mainMenu();

            } else {
                System.out.println("Invalid username or password.");
                return;
            }
        }
    
    public static void mainMenu() {
        User currentUser = users[indexUser];

        while (true) {
            System.out.println();
            System.out.println("-- Welcome " + currentUser.username + " to Aurea Virtual Bank --");
            System.out.println("| Account Info    [1]");
            System.out.println("| Transaction     [2]");
            System.out.println("| View Balance    [3]");
            System.out.println("| Add Suggestion  [4]"); 
            System.out.println("| View Suggestion [5]"); 
            System.out.println("| Edit Suggestion [6]"); 
            System.out.println("| Logout          [7]");
            System.out.print("Choose a menu: ");
            int choice = Scn.nextInt();
            Scn.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    User.displayInfo(currentUser);
                    System.out.println();
                    System.out.print("Go Back to Main Menu press Enter. . . ");
                    Scn.nextLine();
                    mainMenu();
                    break;

                case 2:
                    Transaction.transactionMenu(currentUser, users);
                    break;

                case 3:
                    System.out.println();
                    Transaction.viewBalance(currentUser);
                    System.out.println();
                    System.out.print("Go Back to Main Menu press Enter. . . ");
                    Scn.nextLine();
                    mainMenu();
                    break;

                case 4: 
                System.out.println();
                System.out.print("Enter your suggestion: ");
                String suggestion = Scn.nextLine();
                currentUser.addSuggestion(suggestionQueue, suggestion);
                break;

                case 5:
                System.out.println();
                suggestionQueue.printQueue();
                System.out.println();
                System.out.print("Go Back to Main Menu press Enter. . . ");
                Scn.nextLine();
                break;

                case 6:
                System.out.println();
                suggestionQueue.editSuggestion();
                break;

                case 7:
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
