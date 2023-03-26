package FrontEnd;

import BusinessLogic.*;
import Database.LoginAndRegisterDAO;
import Database.TransactionDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankingFunction {
    public static void showMenu(User user) throws SQLException {
        while (true) {
            System.out.println("Select option: \n 1.Transfer money \n 2.check balance \n 3.Deposit money \n 4.withdrawal \n 5. Check MiniStatement \n 6.Logout");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            if (x == 1) {
                System.out.println("enter the amount");
                scanner.nextLine();
                int amt1 = scanner.nextInt();
                Integer amount = CheckBalanceService.balance(user);
                if (amount > amt1) {
                    System.out.print("enter the username");
                    scanner.nextLine();
                    String toUserName = scanner.nextLine();
                    int count = LoginAndRegisterDAO.checkIfUsernameIsUnique(toUserName);
                    if (count == 1) {
                        TransferService.transferAmount(toUserName, amt1, user);
                        System.out.println("Successfully transferred amount!");
                    } else {

                        System.out.println("enter a valid username");
                    }
                } else {
                    System.out.println("transaction is not possible");
                }

            } else if (x == 2) {
                try {
                    Integer amount = CheckBalanceService.balance(user);
                    System.out.println("Your balance is: " + amount);
                } catch (SQLException e) {
                    System.out.println("Database Error!");
                }
            } else if (x == 3) {
                System.out.print("Enter the amount: ");
                int amt = scanner.nextInt();
                DepositService.addAmount(user, amt);
                System.out.println("Balance deposited successfully!");
            } else if (x == 4) {
                System.out.println("enter the amount");
                int amt = scanner.nextInt();
                Integer amount = CheckBalanceService.balance(user);
                if (amount > amt) {
                    WithDrawalService.withDrawal(user, amt);

                } else {
                    System.out.println("insufficient balance");
                }
            } else if (x == 5) {
                List<Ministatement> result = TransactionDAO.getMiniStatement(user.getUsername());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|%-25s|%-25s|%-25s|%-25s|%-70s| %n", "Date", "Amount", "Credit", "Debit", "Remark");
                for (int i = 0; i < result.size(); i++) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("|%-25s|%-25d|%-25d|%-25d|%-70s|%n", result.get(i).getDate(),result.get(i).getAmount(),result.get(i).getCredit(), result.get(i).getDebit(),result.get(i).getRemark());
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            } else if (x == 6) {
                break;
            } else {
                System.out.println("enter a valid option");
            }
        }
    }
}