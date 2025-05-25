import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu {
    static VirtualWallet home = new VirtualWallet();

    public static void userMenu() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║           AUREA MAIN MENU            ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Top-up                            ║");
            System.out.println("║ 2. Withdraw                          ║");
            System.out.println("║ 3. Transfer                          ║");
            System.out.println("║ 4. Check Balance                     ║");
            System.out.println("║ 5. Transaction History               ║");
            System.out.println("║ 6. Settings                          ║");
            System.out.println("║ 7. Information                       ║");
            System.out.println("║ 8. Logout                            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Choose your options: "); 
            int menuChoice = Integer.parseInt(scan.nextLine());

            switch (menuChoice) {
                case 1:
                    Menu.topUpMenu();
                    break;

                case 2:
                    //do withdraw
                break;

                case 3:
                    System.out.println("Enter recipient username: ");

                    //do transfer
                    break;

                case 4:
                //check balance
                break;
                
                case 5:
                    Menu.currentUser.showTransactions();
                    break;

                case 6:
                    Menu.settingsMenu();
                    break;

                case 7:
                    Menu.viewProfile();
                    break;

                case 8:
                    System.out.println("\nLoggin out...");
                    running = false;
                    home.main(null);;
                    break;

                default:
                System.out.println("Invalid choice.Please enter 1-8.");
                    }
                }

                catch(InputMismatchException e) {
                System.out.println("Please input wth the correct procedure!");
                scan.nextLine(); 
                scan.nextLine();
            }
        }    
    }
}