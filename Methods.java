import java.util.Scanner;

public class Methods {
    static User currentUser;
    static Scanner scan = new Scanner(System.in);

    ///Efisiensi
    public static void MobileOneClick() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        BANK ONE-CLICK        ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. BCA                       ║");
        System.out.println("║ 2. Mandiri                   ║");
        System.out.println("║ 3. BRI                       ║");
        System.out.println("║ 4. BNI                       ║");
        System.out.println("║ 5. Back                      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Choose your banks: ");
        int oneClk = Integer.parseInt(scan.nextLine());

        switch(oneClk) {

            //BCA One_Click
            case 1:
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║        BCA One-Click         ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║ Info:                        ║");
                System.out.println("║ - Minimum top-up: Rp 10.000  ║");
                System.out.println("║ - Admin Fee     : 6%         ║");
                System.out.println("╚══════════════════════════════╝");

                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║         BCA One-Click        ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("Enter amount to top up: Rp ");
                double BCA = scan.nextDouble();
                scan.nextLine(); // consume newline

                if (BCA >= 10000) {
                    double feeBCA = 0.06;
                    double totalFeeBCA = BCA - (BCA * feeBCA);

                    Menu.currentUser.updateBalance(totalFeeBCA);
                    Menu.currentUser.addTransaction(new Transaction(totalFeeBCA, "Top-Up via BCA One-Click"));

                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║         BCA One-Click        ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.printf ("║ Top-up Success!              ║\n");
                    System.out.printf ("║ Amount: Rp %-16s  ║\n", totalFeeBCA);
                    System.out.printf ("║ Fee (3%%): Rp %-15s ║\n", BCA * feeBCA);
                    System.out.printf ("║ Final Total: Rp %-12s ║\n", totalFeeBCA);
                    System.out.println("╚══════════════════════════════╝");
                    System.out.println();
                    
                } else {
                    System.out.println("\nMinimum amount is Rp 10.000. Please try again.");
                    return; // recursive retry
                }
                break;

            //Mandiri One-Click
            case 2:
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║       Mandiri One-Click      ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║ - Info:                      ║");
                System.out.println("║ - Minimum top-up: Rp 10.000  ║");
                System.out.println("║ - Admin Fee     : 3%         ║");
                System.out.println("╚══════════════════════════════╝");
                
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║       Mandiri One-Click      ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.print  ("Enter amount to top-up: Rp. ");
                double Mandiri = Double.parseDouble(scan.nextLine());
                double totalFeeMandiri;
                double feeMandiri = 0.03;
                totalFeeMandiri = (Mandiri - (Mandiri * feeMandiri));

                if (Mandiri >= 10000) {
                    Menu.currentUser.updateBalance(totalFeeMandiri);
                    Menu.currentUser.addTransaction(new Transaction(totalFeeMandiri, "Top-Up"));
                    
                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║       Mandiri One-Click      ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.printf ("║ Top-up Success!              ║\n");
                    System.out.printf ("║ Amount: Rp %-16s  ║\n", totalFeeMandiri);
                    System.out.printf ("║ Fee (3%%): Rp %-15s ║\n", Mandiri * feeMandiri);
                    System.out.printf ("║ Final Total: Rp %-12s ║\n", totalFeeMandiri);
                    System.out.println("╚══════════════════════════════╝");

                } else {
                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║ Minimum top-up is Rp10.000   ║");
                    System.out.println("╚══════════════════════════════╝");
                    return;
                }
                    scan.nextLine();
                break;
            //BRI One-Click

            case 3:
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║        BRI One-Click         ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║ Info:                        ║");
                System.out.println("║ - Minimum top-up: Rp 10.000  ║");
                System.out.println("║ - Admin Fee     : 3%         ║");
                System.out.println("╚══════════════════════════════╝");

                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║         BRI One-Click        ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("\nEnter ammount to top up: ");
                double BRI = Double.parseDouble(scan.nextLine());
                double totalFeeBRI;
                double feeBRI = 0.03;
                totalFeeBRI = (BRI - (BRI * feeBRI));
                        
                if (BRI >= 10000) {
                    Menu.currentUser.updateBalance(totalFeeBRI);
                    Menu.currentUser.addTransaction(new Transaction(totalFeeBRI, "Top-Up"));

                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║       Mandiri One-Click      ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.printf ("║ Top-up Success!              ║\n");
                    System.out.printf ("║ Amount: Rp %-16s  ║\n", totalFeeBRI);
                    System.out.printf ("║ Fee (3%%): Rp %-15s ║\n", BRI * feeBRI);
                    System.out.printf ("║ Final Total: Rp %-12s ║\n", totalFeeBRI);
                    System.out.println("╚══════════════════════════════╝");
                    System.out.println();
                    return;

                } else {
                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║ Minimum top-up is Rp10.000   ║");
                    System.out.println("╚══════════════════════════════╝");
                    scan.nextLine();
                    return;
                }

            //BNI One-Click
            case 4:
                System.out.print("\nEnter ammount to top up: ");
                double BNI = Double.parseDouble(scan.nextLine());
                double totalFeeBNI;
                double feeBNI = 0.10;
                totalFeeBNI = (BNI - (BNI * feeBNI));
                        
                if (BNI >= 10000) {
                    Menu.currentUser.updateBalance(totalFeeBNI);
                    Menu.currentUser.addTransaction(new Transaction(totalFeeBNI, "Top-Up"));
                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║        BNI One-Click      ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.printf ("║ Top-up Success!              ║\n");
                    System.out.printf ("║ Amount: Rp %-16s  ║\n", totalFeeBNI);
                    System.out.printf ("║ Fee (3%%): Rp %-15s ║\n", BNI * feeBNI);
                    System.out.printf ("║ Final Total: Rp %-12s ║\n", totalFeeBNI);
                    System.out.println("╚══════════════════════════════╝");
                    return;

                } else {
                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║ Minimum top-up is Rp10.000   ║");
                    System.out.println("╚══════════════════════════════╝");
                    scan.nextLine();
                    return;

                }
                default:
                System.out.println("Invalid Choice. Choose again.");
                break;
                }
        }


    
    public static void topUpMinimarket() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      MINIMARKET CHOICES      ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. Alfamart                  ║");
        System.out.println("║ 2. Indomaret                 ║");
        System.out.println("║ 3. Lawson                    ║");
        System.out.println("║ 4. Back                      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("Enter your choices: ");
        int miniMrkt = scan.nextInt();

        switch (miniMrkt) {
        case 1:
        System.out.print("Enter amount to top up: ");
            double amount = Double.parseDouble(scan.nextLine());
            
        if (amount < 10000) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║ Minimum top-up is Rp10.000   ║");
            System.out.println("╚══════════════════════════════╝");
            return;

        } else {
            double fee = 0.05;
            double updBalance;
            updBalance = amount - (amount * fee);
            System.out.println("Please visit the nearest store to pay.");
                System.out.println("\n--------------- AUREA VIRTUAL WALLET ---------------  ");
                System.out.println("                                                        ");
                System.out.println("         Store Name: Alfamart"                         );
                System.out.println("         Beneficiary Name: " + currentUser.getName()       );
                System.out.println("         Your AUREA Balance is reduced by Rp." + updBalance);
                System.out.println("         Top-up code: ALF" + (int)(Math.random() * 1000000));
                System.out.println("         Date: 26/05/2025"                               );
                System.out.println("----------------------------------------------------    ");
            }
        }
    }
}