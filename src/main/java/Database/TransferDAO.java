package Database;

import BusinessLogic.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferDAO {
    public static void transferAmt(String username, Integer newAmount) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("update bank set amount = ? where username = ?");
        stmt.setInt(1, newAmount);
        stmt.setString(2, username);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}



