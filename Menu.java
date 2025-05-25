import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
static Scanner scan = new Scanner(System.in);

//Dia memasukan kedalam kelas yang sama seperti di VirtualWallet, dalam sini dia memiliki ditil E-wallet
 static StackLinkedList userStack = new StackLinkedList();

//

        public static void settingsMenu() {
             boolean settingmenus = false;

             do {
            try {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║         Settings Menu        ║");
            System.out.println("║══════════════════════════════║");
            System.out.println("║ 1. Profile                   ║");
            System.out.println("║ 2. Change Username           ║");
            System.out.println("║ 3. Change Password           ║");
            System.out.println("║ 4. Show Login History        ║");
            System.out.println("║ 5. Delete Account            ║");
            System.out.println("║ 6. Back                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose your options: ");
            int choices = scan.nextInt();
            switch (choices) {
                case 1:
                    viewProfile();
                    break;
                
                case 2:
                    
                    break;
                
                case 3:

                    break;

                case 4:
                return;

                default:
                System.out.println("Invalid Choices. Try Again!");
                    } 
                }
            catch(InputMismatchException e) {
            System.out.println("Please input wth the correct procedure!");
            scan.nextLine(); 
        }
     } while (!settingsmenu);
        
    } 
        public static void topUpMenu() {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          Top Up Menu         ║");
            System.out.println("║══════════════════════════════║");
            System.out.println("║ 1. E-Wallet                  ║");
            System.out.println("║ 2. Pulsa                     ║");
            System.out.println("║ 3. Bank One-Click            ║");
            System.out.println("║ 4. Minimarket                ║");
            System.out.println("║ 5. Back                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose your options: ");
            int choices = scan.nextInt();
            
            switch(choices) {
                case 1:
                    // masuk ke menu top up e wallet
                    eWalletMenu();
                    
                    break;
                
                case 2:
                    // masuk ke menu pulsa
                    pulsaMenu();

                    
                    break;
                
                case 3:
                    //
                    break;

                case 4:

                    break;

                case 5:
                    //kembali ke menu utama
                return;

                default:
                System.out.println("Invalid Choices. Try Again!");
            }
            
        }

        //E-Wallet
        public static void eWalletMenu(){
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║         Settings Menu        ║");
            System.out.println("║══════════════════════════════║");
            System.out.println("║ 1. OVO                       ║");
            System.out.println("║ 2. Go-Pay                    ║");
            System.out.println("║ 3. Shoppe-Pay                ║");
            System.out.println("║ 4. Tokped-Pay                ║");
            System.out.println("║ 5. Back                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose your options: ");
            int choices = scan.nextInt();
            //Operasi Pop balance ke sini

            switch (choices) {
                case 1:
                    // jika ovo maka terkena biaya admin 2.000
                    break;

                case 2:
                    // jika gopay terkena biaya admin 1.000
                    break;

                case 3:
                    //jika shoppe pay akan terkena biaya admin 1.500
                    break;
                
                case 4:
                    // kembali ke menu Top up
                    break;
                
                default :
                    System.out.println("Invalid Choices. Try Again!");
                return;


            }
        }
        
        public static void pulsaMenu(){
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          Menu Pulsa          ║");
            System.out.println("║══════════════════════════════║");
            System.out.println("║ 1. Rp 25.000                 ║");
            System.out.println("║ 2. Rp 50.000                 ║");
            System.out.println("║ 3. Rp 100.000                ║");
            System.out.println("║ 4. Rp 200.000                ║");
            System.out.println("║ 5. Back                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose your options: ");
            int choices = scan.nextInt();
            //Operasi Pop balance ke sini

            switch (choices) {
                case 1:
                    // tidak ada biaya
                    break;

                case 2:
                    // tidak ada biaya
                    break;

                case 3:
                    //tidak ada biaya
                    break;

                case 4:
                    // kembali ke menu top up
                return;

                default:
                System.out.println("Invalid Choices. Try Again!");
            }
        }

        public static void bankOneClickMenu() {
    
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       BANK ONE-CLICK         ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. BCA                       ║");
        System.out.println("║ 2. Mandiri                   ║");
        System.out.println("║ 3. BRI                       ║");
        System.out.println("║ 4. BNI                       ║");
        System.out.println("║ 5. Back                      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Choose your bank: ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.print("Enter amount to top up: ");
                double amount = scan.nextDouble();
                // Lakukan top up ke saldo user
                // currentUser.addBalance(amount);
                System.out.println("Top-up successful via Bank!");
                break;
            case 5:
                topUpMenu();
                return;
            default:
                System.out.println("Invalid option.");
        }
        System.out.print("Press enter to go back...");
        scan.nextLine(); scan.nextLine();
        topUpMenu();
    }

    public static void minimarketMenu() {
    System.out.println("╔══════════════════════════════╗");
    System.out.println("║         MINIMARKET           ║");
    System.out.println("╠══════════════════════════════╣");
    System.out.println("║ 1. Alfamart                  ║");
    System.out.println("║ 2. Indomaret                 ║");
    System.out.println("║ 3. Back                      ║");
    System.out.println("╚══════════════════════════════╝");
    System.out.print("Choose your option: ");
    int choice = scan.nextInt();
    switch (choice) {
        case 1:
        case 2:
            System.out.print("Enter amount to top up: ");
            double amount = scan.nextDouble();
            System.out.println("Please visit the nearest store to pay.");
            System.out.println("Top-up code: " + (int)(Math.random() * 1000000));
            break;
        case 3:
            topUpMenu();
            return;
        default:
            System.out.println("Invalid option.");
    }
    System.out.print("Press enter to go back...");
    scan.nextLine(); scan.nextLine();
    topUpMenu();
}


        public static void viewProfile() {
        System.out.println("────────────────────────");
        System.out.println("|      USER PROFILE    |");
        System.out.println("|──────────────────────|");
        System.out.println("| Username:            |");
        System.out.println("| Name:                |");
        System.out.println("| Password: (******)   |");
        System.out.println("| Saldo:               |");
        System.out.println("|                      |");
        System.out.println("────────────────────────");
        System.out.print("Press enter to go back...");
        scan.nextLine(); // menunggu enter
        settingsMenu();
    }
}