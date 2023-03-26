package BusinessLogic;

import Database.TransactionDAO;
import Database.WithDrawalDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class WithDrawalService {
    public static void withDrawal(User user,int amount) throws SQLException {
        Integer existingAmount = CheckBalanceService.balance(user);
        Integer newAmount = existingAmount - amount;
        WithDrawalDAO.withDrawAmount(user,newAmount);

        // ministatement
        TransactionDAO.miniStatement(user.getUsername(), newAmount, String.valueOf(LocalDateTime.now()), amount, 0, "Amount " + amount + " debited from " + user.getUsername() + "." );
    }
}
