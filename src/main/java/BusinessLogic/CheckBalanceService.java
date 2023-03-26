package BusinessLogic;

import Database.CheckBalanceDAO;

import java.sql.SQLException;

public class CheckBalanceService {
    public static Integer balance(User user) throws SQLException {
        return  CheckBalanceDAO.checkBal(user);
    }
}
