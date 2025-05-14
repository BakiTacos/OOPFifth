import java.util.Scanner;

public class Admin {
    Scanner Scn = new Scanner(System.in);
    private String username;
    private String password;
    static SuggestionQueue suggestionQueue = new SuggestionQueue(100);

    public void suggestionQueue(SuggestionQueue suggestionQueue) {
        this.suggestionQueue = suggestionQueue;
    }
    
    public Admin (String username, String password) {
        this.username = username;
        this.password = password;
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

    public void selectionSort(User[] users) {
        for (int i = 0; i < users.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < users.length; j++) {
                if (users[j] != null && users[minIndex] != null && users[j].getUsername().compareTo(users[minIndex].getUsername()) < 0) {
                    minIndex = j;
                }
            }

            for (int j = i + 1; j < users.length; j++) {
                if (users[j] != null && users[minIndex] != null) {
                    User temp = users[i];
                    users[i] = users[minIndex];
                    users[minIndex] = temp;
                    break;
                }
            }
        }
    }

    public void deleteUser(User[] users) {
        System.out.print("Delete user by card Number: ");
        String CN = Scn.nextLine();

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getCardNumber().equals(CN)) {
                users[i] = null;
                System.out.println("Number " + CN + " deleted.");
                return;
            }
        }
        System.out.println("User with card number" + CN + " not found");
    }

    public void adminMenu(User[] users) {

        while (true) {
            System.out.println();
            System.out.println("-- Welcome Back Admin --");
            System.out.println("| Data User            [1]");
            System.out.println("| Block User           [2]");
            System.out.println("| View Suggestion      [3]"); 
            System.out.println("| Clear Suggestion     [4]"); 
            System.out.println("| Logout               [5]");
            System.out.print("Choose a menu: ");
            int choice = Scn.nextInt();
            Scn.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    selectionSort(users);
                    dataView(users);
                    System.out.print("Go Back to Main Menu press Enter. . . ");
                    Scn.nextLine();
                    adminMenu(users);
                    break;

                case 2:
                    deleteUser(users);
                    System.out.print("Go Back to Main Menu press Enter. . . ");
                    Scn.nextLine();
                    adminMenu(users);
                    break;
                    
                case 3: 
                suggestionQueue.printQueue(); 
                break;

                case 4: 
                    suggestionQueue.clear();
                break;

                case 5:
                    Main.mainMenu();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void adminLogin(User[] users, Admin admin) {
        System.out.println();
        System.out.println("-- Admin Login --");
        System.out.print("Enter admin user code: ");
        String username = Scn.nextLine();

        System.out.print("Enter admin pass code: ");
        String password = Scn.nextLine();

        if(username.equals("admin") && password.equals("6969")) {
            adminMenu(users);     

        } else {
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("|Nice try. You're trying to rob admin's data, do you?|");
            System.out.println("----------------------------------------------------");
            return;
        }
    }

    public void dataView(User[] users) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                User.displayInfo(users[i]);
                System.out.println();

            } else {
                System.out.println("No other user registered");
                break;
            }
        }
    }
}