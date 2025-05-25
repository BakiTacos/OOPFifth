import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {   
static Scanner scan = new Scanner(System.in);
//Dia memasukan kedalam kelas yang sama seperti di VirtualWallet, dalam sini dia memiliki ditil E-wallet
static StackLinkedList userStack = new StackLinkedList();
static VirtualWallet home = new VirtualWallet();
static User currentUser;


        public static void settingsMenu() {
            boolean settingmenus = true;

            do  {
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
            int choices = Integer.parseInt(scan.nextLine());
            
            switch (choices) {
                case 1:
                viewProfile();
                break;
                
                case 2:
                System.out.println("\n=== CHANGE USERNAME ===");
                System.out.print("Enter new username: ");
                String newUsername = scan.nextLine();

                System.out.println("Enter your password to confirm deletion: ");
                String passwordConfirmusername = scan.nextLine();
                if (!passwordConfirmusername.equals(currentUser.getPass())) {
                System.out.println("Wrong password. Deletion failed.");
                break;
                }
                System.out.print("Confirm Change? (Y/N): ");
                String confirm = scan.nextLine().toLowerCase();
                
                if (confirm.equals("y")) {
                currentUser.setUsername(newUsername);
                    currentUser = null;
                    home.main(null); 
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
                
                case 3:
                
                break;

                case 4:
                return;

                case 5:
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║     !!!DELETE ACCOUNT!!!     ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("Enter your password to confirm deletion: ");
                String passwordConfirm = scan.nextLine();

                if (passwordConfirm.equals(currentUser.getPass()) == false) {
                System.out.println("Wrong password. Deletion failed.");
                break;
                }
                System.out.print("Confirm delete? (Y/N): ");
                String confirm1 = scan.nextLine().toLowerCase();
                
                if (confirm1.equals("y")) {
                    VirtualWallet.bankUser.deleteUser(currentUser.getUsername());
                    currentUser = null;
                    home.main(null); 
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
                
                default:
                System.out.println("Invalid Choices. Try Again!");
                } 
                }
                catch(InputMismatchException e) {
                System.out.println("Please input wth the correct procedure!");
                scan.nextLine(); 
                }
                } while (!settingmenus);
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
            int choices = Integer.parseInt(scan.nextLine());
            
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
                Methods.MobileOneClick();
                break;

                case 4:
                Methods.topUpMinimarket();
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
            int choices = Integer.parseInt(scan.nextLine());
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




        //Menu Pulsa tidak memiliki biaya dan hanya mengurang 
        public static void pulsaMenu(){
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          MENU PULSA          ║");
            System.out.println("║══════════════════════════════║");
            System.out.println("║ 1. Rp 25.000                 ║");
            System.out.println("║ 2. Rp 50.000                 ║");
            System.out.println("║ 3. Rp 100.000                ║");
            System.out.println("║ 4. Rp 200.000                ║");
            System.out.println("║ 5. Back                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Choose your options: ");
            int choices = Integer.parseInt(scan.nextLine());
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
                
                case 5:
                    pulsaMenu();
                    break;
                
                default:
                System.out.println("Invalid Choices. Try Again!");
                pulsaMenu();
                }
                }
                

        public static void viewProfile() {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║         USER PROFILE         ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf ("║ %-10s : %-16s ║\n", "Username", currentUser.getUsername());
            System.out.printf ("║ %-10s : %-16s ║\n", "Name", currentUser.getName());
            System.out.printf ("║ %-10s : %-16s ║\n", "Password", "*******");
            System.out.printf ("║ %-10s : Rp %-12s ║\n", "Saldo", currentUser.getBalance());
            System.out.println("╚══════════════════════════════╝");
            System.out.println();
            System.out.print("Press enter to go back...");
            scan.nextLine(); // menunggu enter
            settingsMenu();
            }
            
        public static void checkBalanceMenu(User user) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║           BALANCE CHECK            ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.printf("║ Your Current Balance: Rp %-10.2f ║\n", user.getBalance());
            System.out.println("╚════════════════════════════════════╝");
            }
}