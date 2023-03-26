package FrontEnd;

import BusinessLogic.LoginAndRegisterService;
import BusinessLogic.User;

import java.util.Scanner;

public class Login {
    public static void userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("enter PASSWORD: ");
        String password = scanner.nextLine();


        try {
           User user= LoginAndRegisterService.userValidate(username, password);
            System.out.println("Welcome " + user.getFname()+ " "+ user.getLname());
            BankingFunction.showMenu(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}