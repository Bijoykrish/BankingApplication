package Database;

import BusinessLogic.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithDrawalDAO {
    public static void withDrawAmount(User user, Integer newAmount) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("update bank set amount = ? where username = ?");
        stmt.setInt(1, newAmount);
        stmt.setString(2, user.getUsername());
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}