package BusinessLogic;

import Database.LoginAndRegisterDAO;
import Database.TransactionDAO;
import Database.TransferDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransferService {
    public static void transferAmount(String toUserName, int amt, User fromUser) throws SQLException {
        // adding money to receiver account
        User toUser = LoginAndRegisterDAO.customerInfo(toUserName);
        Integer toUserExistingAmount = CheckBalanceService.balance(toUser);
        Integer newAmount = toUserExistingAmount + amt;
        String localDateTime =  String.valueOf(LocalDateTime.now());
        System.out.println(localDateTime);
        TransferDAO.transferAmt(toUserName, newAmount);
        TransactionDAO.miniStatement(toUserName, newAmount, String.valueOf(LocalDateTime.now()), 0, amt, "Amount " + amt + " transferred from " + fromUser.getUsername() + "." );

        // deducting money from the sender account
        Integer fromUserExistingAmount = CheckBalanceService.balance(fromUser);
        newAmount = fromUserExistingAmount - amt;
        TransferDAO.transferAmt(fromUser.getUsername(), newAmount);
        TransactionDAO.miniStatement(fromUser.getUsername(), newAmount, String.valueOf(LocalDateTime.now()), amt, 0, "Amount " + amt + " transferred to " + toUserName + "." );
    }

}
