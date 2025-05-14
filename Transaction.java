import java.util.Scanner;

public class Transaction {
    static Scanner Scn = new Scanner(System.in);

    public static void transactionMenu(User currentUser, User[] users) {
        System.out.println();
        System.out.println("--- Transaction Menu ---");
        System.out.println("| Deposit             [1]");
        System.out.println("| Withdraw            [2]");
        System.out.println("| Transfer            [3]");
        System.out.println("| Transfer History    [4]");
        System.out.println("| Back                [5]");
        System.out.print("Choose a menu: ");
        int choices = Scn.nextInt();
        Scn.nextLine();

        switch (choices) {
            case 1:
                System.out.println();
                System.out.print("Enter amount: ");
                double depositAmount = Scn.nextDouble();
                Scn.nextLine();
                
                if (depositAmount > 50000000) {
                    System.out.println("Max Deposit Reached (Rp. 50.000.000)");
                    System.out.print("Go Back to Main Menu press Enter. . . ");
                    Scn.nextLine();
                    transactionMenu(currentUser, users);
                    break;
                
                } else {
                currentUser.setBalance(currentUser.getBalance() + depositAmount);
                System.out.println("Deposit successful!");
                System.out.println("New Balance: IDR " + currentUser.getBalance());
                transactionMenu(currentUser, users);
                break;
                }

            case 2:
                System.out.println();
                System.out.print("Enter amount: ");
                double withdrawAmount = Scn.nextDouble();
                Scn.nextLine();
                System.out.println();
                
                if (currentUser.getBalance() >= withdrawAmount) {
                    currentUser.setBalance(currentUser.getBalance() - withdrawAmount);
                    System.out.println("Withdraw successful.");
                    viewBalance(currentUser);
                    transactionMenu(currentUser, users);

                } else {
                    System.out.println("Insufficient balance!");
                    transactionMenu(currentUser, users);
                    break;
                }
                    break;
            case 3:
                transfer(currentUser, users);
                transactionMenu(currentUser, users);
                break;

            case 4:
                currentUser.viewHistory();
                transactionMenu(currentUser, users);
                break;

            case 5:
                Main.mainMenu();
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void viewBalance(User user) {
        System.out.println("Balance: IDR " + user.getBalance());
    } 

    private static void transfer(User currentUser, User[] users) {
        System.out.println();
        System.out.print("Destination account number: ");
        String destinationNumber = Scn.nextLine();

        User destination = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].cardNumber.equals(destinationNumber)) {
                destination = users[i];
                break;
            }
        }
        
        if (destination == null) {
            System.out.println("Destination number not found!");
            transactionMenu(currentUser, users);
        }

        System.out.print("Enter amount: ");
        double amount = Scn.nextDouble();
        Scn.nextLine(); 

        if (currentUser.balance < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        currentUser.setBalance(currentUser.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        currentUser.tfHistory(destination.username, amount);

        System.out.println();
        System.out.println("Transfer successful! New balance: IDR " + currentUser.balance);
        System.out.println(destination.username + " new balance: IDR " + destination.balance);
        return;
        }
    }