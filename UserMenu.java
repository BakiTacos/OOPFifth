import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu {
    static VirtualWallet home = new VirtualWallet();
    public static void userMenu() {
    Scanner scan = new Scanner(System.in);
    boolean running = true;

        while (running){
            try {
            System.out.println("\n────────────────────────────");
            System.out.println("|         Main Menu        |");
            System.out.println("|──────────────────────────|");
            System.out.println("| 1. Top-up                |"); // Untuk Top up dia memecah untuk menu top up
            System.out.println("| 2. Withdraw              |");
            System.out.println("| 3. Transfer              |"); // Memindahkan Uang ke akun lain (Method sendiri)
            System.out.println("| 4. Check Balance         |"); // Mengecek jumlah uang yang dimiliki user (getBalance)
            System.out.println("| 5. Transaction History   |"); // Melihat Sejarah Transaksi (Disimpan pake stack)
            System.out.println("| 6. Settings              |"); // Untuk mengatur akun (Cek Prof,Change User,Change Pass)
            System.out.println("| 7. Information           |"); // Melihat Informasi Bantuan (Sysout doang)
            System.out.println("| 8. Logout                |"); // Keluar dari akun
            System.out.println("────────────────────────────");
            System.out.print("Choose your options: "); 
            int menuChoice = scan.nextInt();

            switch (menuChoice) {
                case 1:
                    //do Top up
                    break;
                case 2:
                    //do withdraw
                    break;
                case 3:
                    //do transfer
                    break;
                case 4:
                    //check balance
                    break;
                case 5:
                    //check transaction history
                    break;
                case 6:
                    Menu.settingsMenu();
                    break;
                case 7:
                    //Informations
                    break;
                case 8:

                    System.out.println("Loggin out...");
                    running = false;
                    home.main(null);;
                    break;
                default:
                    System.out.println("Invalid choice.");
                }
            }
            catch(InputMismatchException e) {
            System.out.println("Please input wth the correct procedure!");
            scan.nextLine(); 
            }
        }    
    }
}
