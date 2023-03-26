package BusinessLogic;

import Database.DepositDAO;
import Database.TransactionDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class DepositService {
    public static void addAmount(User user, Integer amt) throws SQLException {
        Integer existingAmount = CheckBalanceService.balance(user);
        Integer newAmount = existingAmount + amt;
        DepositDAO.depositAmt(user, newAmount);

        TransactionDAO.miniStatement(user.getUsername(), newAmount, String.valueOf(LocalDateTime.now()), 0, amt, "Amount " + amt + " credited to " + user.getUsername() + "." );
    }
}
