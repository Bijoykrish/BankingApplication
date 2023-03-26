package Database;

import BusinessLogic.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalanceDAO {
    public static Integer checkBal(User user) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select amount from bank where username = ? ");
        stmt.setString(1, user.getUsername());
        ResultSet resultSet = stmt.executeQuery();
        Integer amount = 0;
        while (resultSet.next()) {
            amount = resultSet.getInt("amount");
        }
        return amount;
    }
}
