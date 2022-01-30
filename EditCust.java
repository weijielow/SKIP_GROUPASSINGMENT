package GAsg;

import java.util.Scanner;

public class EditCust {

    private static Scanner scan = new Scanner(System.in);

    public static void modify(int[] ID, String[] names, String[] HomeAddress, String[] EmailAddress) {
        char modify = 0, a = 0;
        int change = 0;
        boolean status = false;
        // Q4:Edit Customer:
        // start
        do {
            do {
                System.out.println("");
                System.out.print("ENTER CUSTOMER ID>  ");
                int cusID = scan.nextInt();
                boolean newCus = true;
                do {
                    for (int a = 0; a < ID.length; a++) {
                        if (cusID == ID[a]) {
                            newCus = false;
                        }
                    }
                    if (newCus == true) {
                        System.out.println("Invalid customer ID, please enter again.");
                        cusID = scan.nextInt();
                    }
                } while (newCus == true);
                for (a = 0; a < ID.length; a++) {
                    if (cusID == ID[a]) {
                        change = SelectSection();

                        while (change < 1 || change > 3) {
                            System.out.print("PLEASE ENTER WTH NUMBER 1-3 only.");
                            change = scan.nextInt();
                        }
                        InputNew(change, names, HomeAddress, EmailAddress, a);

                        System.out.println("=============================================================");
                        System.out.println("Congratulation! Details of ID " + cusID + " have been change successfully.");
                        System.out.println("=============================================================");
                        System.out.println("Latest Details : ");
                        System.out.println("NAME           : " + names[a]);
                        System.out.println("HOME ADDRESS   : " + HomeAddress[a]);
                        System.out.println("EMAIL ADDRESS  : " + EmailAddress[a]);
                        System.out.println("=============================================================");
                        break;
                    }
                }

                if (a == ID.length) {
                    status = false;
                    System.out.println("INVALID CUSTOMER ID!");
                    System.out.println("Please Register before login>");
                }
            } while (status == false);

            System.out.print("ENTER Y TO CONTINUE MODIFY OR N TO QUIT> ");// ask whether to
            modify = scan.next().charAt(0);
            // change again
            if (modify == 'y' || modify == 'Y') {
                System.out.println("");
            } else if (modify != 'y' && modify != 'Y' && modify != 'n' && modify != 'N') {
                System.out.println("INVALID!");
                System.out.print("ENTER Y TO CONTINUE MODIFY OR N TO QUIT> ");
                modify = scan.next().charAt(0);
            } else if (modify == 'n' || modify == 'N') {
                System.out.println("=============================================================");
                System.out.println("");
                break;
            }

        } while (modify == 'y' || modify == 'Y' || modify == 'n' || modify == 'N');
    }

    public static int SelectSection() {
        System.out.println("*************************************************************");
        System.out.println("=============================================================");
        System.out.println("|name                                                     1 |");
        System.out.println("|home address                                             2 |");
        System.out.println("|email address                                            3 |");
        System.out.println("=============================================================");
        System.out.println("");
        System.out.print("ENTER THE SECTION THAT YOU WANT TO CHANGE (1-3): ");// choose either one by tping 1 2 3

        int change = scan.nextInt();
        return change;
    }

    public static void InputNew(int change, String[] N, String[] H, String[] E, int a) {
        if (change == 1) {
            System.out.print("ENTER THE NEW CUSTOMER NAME>  ");
            String name = scan.next() + scan.nextLine();
            N[a] = name;
        } else if (change == 2) {
            System.out.print("ENTER THE NEW CUSTOMER HOME ADDRESS> ");
            String address = scan.next() + scan.nextLine();
            H[a] = address;
        } else if (change == 3) {
            System.out.print("ENTER THE NEW CUSTOMER EMAIL ADDRESS> ");
            String email = scan.next() + scan.nextLine();
            E[a] = email;
        }
    }

}
