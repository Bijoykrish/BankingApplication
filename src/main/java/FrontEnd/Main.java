package FrontEnd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("WELCOME TO THE BANKING APPLICATION");
            System.out.println("CHOOSE THE FOLLOWING OPTIONS \n 1.LOGIN \n 2.REGISTER \n 3.EXIT  ");
            x = scanner.nextInt();
            if (x == 1) {
                System.out.println("WELCOME TO LOGIN INTERFACE");
                Login.userLogin();

            } else if (x == 2) {
                System.out.println("WELCOME TO REGISTER INTERFACE");
                Register.UserReg();

            } else if (x == 3) {
                System.out.println("THANK YOU AND VISIT AGAIN");
                break;
            } else {
                System.out.println("ENTER A VALID OPTION");
            }
        }



    }
}
